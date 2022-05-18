package com.bnta.dark_heresy_character_sheet.controllers;

import com.bnta.dark_heresy_character_sheet.models.Dude;
import com.bnta.dark_heresy_character_sheet.repositories.DudeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("dudes")
public class DudeController {

    @Autowired
    DudeRepository dudeRepository;

    //INDEX
    @GetMapping //localhost:8080/dudes
    public ResponseEntity<List<Dude>> getAllDudes(){
        return new ResponseEntity<>(dudeRepository.findAll(), HttpStatus.OK);
    }

    //SHOW
    @GetMapping(value = "/{id}") //localhost:8080/dudes/1
    public ResponseEntity<Optional<Dude>> getPet(@PathVariable Long id){
        return new ResponseEntity<>(dudeRepository.findById(id), HttpStatus.OK);
    }

    //POST
    @PostMapping //POST localhost:8080/dude
    public ResponseEntity<Dude> createPet(@RequestBody Dude newDude){
        dudeRepository.save(newDude);
        return new ResponseEntity<>(newDude, HttpStatus.CREATED);
    }
}
