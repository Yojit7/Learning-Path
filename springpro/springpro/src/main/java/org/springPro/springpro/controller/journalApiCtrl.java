package org.springPro.springpro.controller;
import org.springPro.springpro.entity.JouranlEntry;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class journalApiCtrl{


    private final Map<Long, JouranlEntry> journalData= new HashMap<>();


    @GetMapping("/getJournal")
    public List<JouranlEntry> getJouranlEntries(){
        return  new ArrayList<>(journalData.values());
    }

    @PostMapping("postJournal")
    public boolean createJournal(@RequestBody JouranlEntry jouranlEntry){
        journalData.put(jouranlEntry.getId(), jouranlEntry);
        return true;
    }

    @GetMapping("/getJournal/{myId}")
    public JouranlEntry  getJournalById(@PathVariable Long myId){
        return  journalData.get(myId);
    }

    @DeleteMapping("/getJournal/{myId}")
    public JouranlEntry deleteJournalById(@PathVariable Long myId){
        return  journalData.remove(myId);
    }

    @PutMapping("/updateJournal/{myId}")
    public JouranlEntry updateJournalById(@PathVariable Long myId ,@RequestBody JouranlEntry jouranlEntry){
        return  journalData.put(myId,jouranlEntry);
    }




}