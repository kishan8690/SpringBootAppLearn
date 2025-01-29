package com.kishan.journalApp.controller;


import com.kishan.journalApp.entity.JournalEntry;
import com.kishan.journalApp.service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {
    @Autowired
    private JournalEntryService journalEntryService;
    @GetMapping
    public ResponseEntity<?> getAll() {

        List<JournalEntry> journalEntries = journalEntryService.getAll();
        if (!journalEntries.isEmpty() && journalEntries!=null) {
            return new ResponseEntity<>(journalEntries,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<JournalEntry> createJournalEntry(@RequestBody JournalEntry journalEntry) {
       try {
           journalEntry.setDate(LocalDateTime.now());
           journalEntryService.saveEntry(journalEntry);
           return  new ResponseEntity<>(journalEntry, HttpStatus.CREATED);
       }catch (Exception e){
           return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
       }
    }

    @GetMapping("id/{myID}")
    public ResponseEntity<JournalEntry> getJournalEntryById(@PathVariable ObjectId myID) {
        Optional<JournalEntry> journalEntry = journalEntryService.getJournalEntryById(myID);
        if(journalEntry.isPresent()){
            return  new ResponseEntity<>(journalEntry.get(), HttpStatus.OK);
        }
        return  new ResponseEntity<>(journalEntry.get(), HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("id/{myID}")
    public ResponseEntity<JournalEntry> deleteJournalEntryById(@PathVariable ObjectId myID) {
        journalEntryService.deleteEntryById(myID);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("id/{id}")
    public ResponseEntity<JournalEntry> updateJournalEntry(@PathVariable ObjectId id, @RequestBody JournalEntry newEntry) {

        JournalEntry old  = journalEntryService.getJournalEntryById(id).orElse(null);
        if (old != null) {
            old.setTitle(newEntry.getTitle()!=null && !newEntry.getTitle().equals("")? newEntry.getTitle() : old.getTitle());
            old.setContent(newEntry.getContent()!=null && !newEntry.getContent().equals("")? newEntry.getContent() : old.getContent());
            journalEntryService.saveEntry(old);
            return new ResponseEntity<>(old, HttpStatus.OK) ;
        }
        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
