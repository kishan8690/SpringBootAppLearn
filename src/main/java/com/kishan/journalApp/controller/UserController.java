package com.kishan.journalApp.controller;

import com.kishan.journalApp.entity.JournalEntry;
import com.kishan.journalApp.entity.UserEntity;
import com.kishan.journalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping
    public List<UserEntity> getAllUsers(){
        return userService.getAll();
    }
    @PostMapping
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity user){
        userService.saveUser(user);
        return new ResponseEntity<UserEntity>(user,HttpStatus.CREATED);
    }
    @PutMapping("/{userName}")
    public  ResponseEntity<?> userUpdate(@RequestBody UserEntity user,@PathVariable String userName){
        UserEntity userInDb=userService.findByUserName(userName);
        if(userInDb!=null){
            userInDb.setUserName(user.getUserName());
            userInDb.setPassword(user.getPassword());
            userService.saveUser(userInDb);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
