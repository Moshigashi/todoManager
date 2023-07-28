package com.todo.todomanager.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getUsers() { return userService.getUsers(); }

    @PostMapping("/users")
    public ResponseEntity<String> saveStudent(@RequestBody User user) {
        User s=userService.saveUser(user);
        return ResponseEntity.ok("user successfully added");
    }

    @PutMapping("/users/{userId}")
    public ResponseEntity<?> updateUser(@RequestParam int userId, @RequestBody User user) {
        Optional<User> userCheck=userService.getUser(userId);
        if(userCheck.isPresent()) {
            user.setUserId(userId);
            User s=userService.saveUser(user);
            return ResponseEntity.ok(s);
        }else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("userId is not found");
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<?> getUser(@PathVariable("userId")int userId){

        Optional<User> user= userService.getUser(userId);
        if(user.isPresent()){
            User s= user.get();
            return ResponseEntity.ok(s);
        }
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("userId is not found");
    }

    @DeleteMapping("/users/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable("userId") int userId) {
        Optional<User> user= userService.getUser(userId);
        if(user.isPresent()) {
            userService.deleteUser(userId);
            return ResponseEntity.ok("user deleted");
        }else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("userId is not found");
    }

}
