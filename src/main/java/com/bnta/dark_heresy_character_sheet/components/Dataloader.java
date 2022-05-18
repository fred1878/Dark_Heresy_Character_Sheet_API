package com.bnta.dark_heresy_character_sheet.components;

import com.bnta.dark_heresy_character_sheet.models.Dude;
import com.bnta.dark_heresy_character_sheet.models.Weapon;
import com.bnta.dark_heresy_character_sheet.models.WeaponAttributes;
import com.bnta.dark_heresy_character_sheet.repositories.DudeRepository;
import com.bnta.dark_heresy_character_sheet.repositories.WeaponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class Dataloader implements ApplicationRunner {

    @Autowired
    DudeRepository dudeRepository;
    @Autowired
    WeaponRepository weaponRepository;
    WeaponAttributes weaponAttributes;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Dude dude1 = new Dude("Venris");
        Dude dude2 = new Dude("Xanthis");
        Dude dude3 = new Dude("Fred");
        dudeRepository.saveAll(Arrays.asList(dude1,dude2,dude3));

        Weapon lasgun = new Weapon("Lasgun","Basic",100,"S/3/-","1d10+3 E",0,60,"Full",75,new ArrayList<>(Arrays.asList(WeaponAttributes.RELIABLE)),dude1);
        Weapon boltgun = new Weapon("Boltgun","Basic",90,"S/2/-","1d10+5 X",4,24,"Full",500,new ArrayList<>(Collections.EMPTY_LIST),dude2);
        Weapon chainsword = new Weapon("Chainsword","Melee",1,"","1d10+2 R",2,0,"",275,new ArrayList<>(Arrays.asList(WeaponAttributes.TEARING)),dude3);
        weaponRepository.saveAll(Arrays.asList(lasgun,boltgun,chainsword));
    }
}
