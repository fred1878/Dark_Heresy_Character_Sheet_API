package com.bnta.dark_heresy_character_sheet.controllers;

import com.bnta.dark_heresy_character_sheet.models.Talent;
import com.bnta.dark_heresy_character_sheet.repositories.TalentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("talents")
public class TalentController {

    @Autowired
    TalentRepository talentRepository;


    //INDEX
    @GetMapping //localhost:8080/talents
    public ResponseEntity<List<Talent>> getAllTalents(){
        return new ResponseEntity<>(talentRepository.findAll(), HttpStatus.OK);
    }

    //SHOW
    @GetMapping(value = "/{id}") //localhost:8080/talents/1
    public ResponseEntity<Optional<Talent>> getTalent(@PathVariable Long id){
        return new ResponseEntity<>(talentRepository.findById(id), HttpStatus.OK);
    }

    //POST
    @PostMapping // localhost:8080/talents
    public ResponseEntity<Talent> createTalent(@RequestBody Talent newTalent){
        talentRepository.save(newTalent);
        return new ResponseEntity<>(newTalent, HttpStatus.CREATED);
    }

    //DELETE
    @DeleteMapping(value = "/{id}") //localhost:8080/talents/1
    public ResponseEntity<Talent> deleteTalent(@PathVariable Long id){
        talentRepository.deleteById(id);
        return new ResponseEntity(id,HttpStatus.OK);
    }
}
