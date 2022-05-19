package com.bnta.dark_heresy_character_sheet.controllers;

import com.bnta.dark_heresy_character_sheet.models.Dude;
import com.bnta.dark_heresy_character_sheet.models.Weapon;
import com.bnta.dark_heresy_character_sheet.repositories.DudeRepository;
import com.bnta.dark_heresy_character_sheet.repositories.WeaponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("weapons")
public class WeaponController {

    @Autowired
    WeaponRepository weaponRepository;

    //INDEX
    @GetMapping //localhost:8080/weapons
    public ResponseEntity<List<Weapon>> getAllWeaponsAndFilters(
            @RequestParam(name = "weaponClass",required = false) String weaponClass,
            @RequestParam(name = "cost",required = false) Integer cost){
        if(weaponClass != null && cost != null){
            List<Weapon> list1 = weaponRepository.findWeaponByWeaponClass(weaponClass);
            List<Weapon> list2 = weaponRepository.findWeaponByCostGreaterThanEqual(cost);
            List<Weapon> out = new ArrayList<>(Stream.of(list1,list2).flatMap(List::stream)
                    .collect(Collectors.toMap(Weapon::getId, d -> d, (Weapon x, Weapon y) -> x == null ? y : x)).values());
            return new ResponseEntity<>(out, HttpStatus.OK);
            //return new ResponseEntity(weaponRepository.findWeaponByWeaponClass(weaponClass).addAll(weaponRepository.findWeaponByCostGreaterThanEqual(cost)),HttpStatus.OK);
        }
        if(weaponClass == null && cost != null){
            return new ResponseEntity(weaponRepository.findWeaponByCostGreaterThanEqual(cost),HttpStatus.OK);
        }
        if(weaponClass != null && cost == null){
            return new ResponseEntity<>(weaponRepository.findWeaponByWeaponClass(weaponClass),HttpStatus.OK);
        }
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
