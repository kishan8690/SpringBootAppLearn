package com.kishan.journalApp.service;

import com.kishan.journalApp.entity.JournalEntry;
import com.kishan.journalApp.entity.UserEntity;
import com.kishan.journalApp.reposetory.JournalEntryReposetory;
import com.kishan.journalApp.reposetory.UserReposetory;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class JournalEntryService {
    @Autowired
    private JournalEntryReposetory journalEntryReposetory;
    @Autowired
    private UserReposetory userReposetory;
    public void saveEntry(JournalEntry journalEntry, String userName) {
        UserEntity user = userReposetory.findByUserName(userName);
        JournalEntry savedJournalEntry=journalEntryReposetory.save(journalEntry);
        user.getJournalEntries().add(savedJournalEntry);
        userReposetory.save(user);
    }
    public void saveEntry(JournalEntry journalEntry) {

        JournalEntry savedJournalEntry=journalEntryReposetory.save(journalEntry);

    }
    public List<JournalEntry> getAll(){
        return  journalEntryReposetory.findAll();
    }
    public Optional<JournalEntry> getJournalEntryById(ObjectId id) {
        return  journalEntryReposetory.findById(id);
    }
    public void deleteEntryById(ObjectId id, String userName) {
        UserEntity user = userReposetory.findByUserName(userName);
        user.getJournalEntries().removeIf(x->x.getId().equals(id));
        userReposetory.save(user);
        journalEntryReposetory.deleteById(id);
    }
}
