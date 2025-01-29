package com.kishan.journalApp.reposetory;

import com.kishan.journalApp.entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JournalEntryReposetory extends MongoRepository<JournalEntry, ObjectId> {

}
