package com.bnta.dark_heresy_character_sheet.controllers;

import com.bnta.dark_heresy_character_sheet.models.Dude;
import com.bnta.dark_heresy_character_sheet.models.Weapon;
import com.bnta.dark_heresy_character_sheet.repositories.DudeRepository;
import com.bnta.dark_heresy_character_sheet.repositories.WeaponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("weapons")
public class WeaponController {

    @Autowired
    WeaponRepository weaponRepository;

    //INDEX
    @GetMapping //localhost:8080/weapons
    public ResponseEntity<List<Weapon>> getAllWeapons(){
        return new ResponseEntity<>(weaponRepository.findAll(), HttpStatus.OK);
    }

    //SHOW
    @GetMapping(value = "/{id}") //localhost:8080/weapons/1
    public ResponseEntity<Optional<Weapon>> getWeapon(@PathVariable Long id){
        return new ResponseEntity<>(weaponRepository.findById(id), HttpStatus.OK);
    }

    //POST
    @PostMapping //POST localhost:8080/weapons
    public ResponseEntity<Weapon> createWeapon(@RequestBody Weapon newWeapon){
        weaponRepository.save(newWeapon);
        return new ResponseEntity<>(newWeapon, HttpStatus.CREATED);
    }

    //DELETE
    @DeleteMapping(value = "/{id}") //localhost:8080/weapons/1
    public ResponseEntity<Weapon> deleteWeapon(@PathVariable Long id){
        weaponRepository.deleteById(id);
        return new ResponseEntity(id,HttpStatus.OK);
    }
}
