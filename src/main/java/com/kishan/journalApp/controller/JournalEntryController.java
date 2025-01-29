//package com.kishan.journalApp.controller;
//
//import com.kishan.journalApp.entity.JournalEntry;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/_journal")
//public class JournalEntryController {
//    private Map<String, JournalEntry> journalEntryMap = new HashMap<>();
//    @GetMapping
//    public List<JournalEntry> getAll(){
//        return new ArrayList<>(journalEntryMap.values()) ;
//    }
//    @PostMapping
//    public boolean createJournalEntry(@RequestBody JournalEntry journalEntry){
//        journalEntryMap.put(journalEntry.getId(),journalEntry);
//        return true;
//    }
//    @GetMapping("id/{myID}")
//    public JournalEntry getJournalEntryById(@PathVariable long myID){
//        return journalEntryMap.get(myID);
//    }
//    @DeleteMapping("id/{myID}")
//    public JournalEntry deleteJournalEntryById(@PathVariable long myID){
//        return journalEntryMap.remove(myID);
//    }
//    @PutMapping("id/{id}")
//    public JournalEntry updateJournalEntry(@PathVariable String id,@RequestBody JournalEntry jounralentry){
//        return journalEntryMap.put(id,jounralentry);
//    }
//}
