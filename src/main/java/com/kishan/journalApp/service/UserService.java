package com.kishan.journalApp.service;

import com.kishan.journalApp.entity.UserEntity;
import com.kishan.journalApp.reposetory.UserReposetory;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserService {
    @Autowired
    private UserReposetory userReposetory;
    public void saveUser(UserEntity user){
        userReposetory.save(user);
    }
    public List<UserEntity> getAll(){return userReposetory.findAll();}
    public Optional<UserEntity> getUserById(ObjectId id){return userReposetory.findById(id);}
    public void deleteUserById(ObjectId id){userReposetory.deleteById(id);}
    public UserEntity findByUserName(String userName){
        return userReposetory.findByUserName(userName);
    }
}
