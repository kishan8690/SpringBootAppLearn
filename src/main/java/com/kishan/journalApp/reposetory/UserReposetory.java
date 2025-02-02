package com.kishan.journalApp.reposetory;

import com.kishan.journalApp.entity.UserEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserReposetory  extends MongoRepository<UserEntity, ObjectId> {
    UserEntity findByUserName(String username);
}
