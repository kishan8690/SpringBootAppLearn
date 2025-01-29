package com.kishan.journalApp.service;

import com.kishan.journalApp.entity.JournalEntry;
import com.kishan.journalApp.reposetory.JournalEntryReposetory;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Component
public class JournalEntryService {
    @Autowired
    private JournalEntryReposetory journalEntryReposetory;

    public void saveEntry(JournalEntry journalEntry) {
        journalEntryReposetory.save(journalEntry);
    }
    public List<JournalEntry> getAll(){
        return  journalEntryReposetory.findAll();
    }
    public Optional<JournalEntry> getJournalEntryById(ObjectId id) {
        return  journalEntryReposetory.findById(id);
    }
    public void deleteEntryById(ObjectId id) {
        journalEntryReposetory.deleteById(id);
    }
}
