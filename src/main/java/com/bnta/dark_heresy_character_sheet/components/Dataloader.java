package com.bnta.dark_heresy_character_sheet.components;

import com.bnta.dark_heresy_character_sheet.models.Dude;
import com.bnta.dark_heresy_character_sheet.models.Talent;
import com.bnta.dark_heresy_character_sheet.models.Weapon;
import com.bnta.dark_heresy_character_sheet.repositories.DudeRepository;
import com.bnta.dark_heresy_character_sheet.repositories.TalentRepository;
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
    @Autowired
    TalentRepository talentRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Talent talent1 = new Talent("Marksman", "You suffer no penalty at Long or Extended range");
        Talent talent2 = new Talent("Die Hard", "When you suffer Blood Loss you may roll twice to avoid death");
        Talent talent3 = new Talent("Technical Knock", "You may unjam any gun as a Half Action, once per Round");
        Talent talent4 = new Talent("Quick Draw", "You may ready as a Free Action");
        talentRepository.saveAll(Arrays.asList(talent1,talent2,talent3,talent4));

        Dude dude1 = new Dude("Venris",Arrays.asList(talent1,talent3));
        Dude dude2 = new Dude("Xanthis",Arrays.asList(talent3,talent4));
        Dude dude3 = new Dude("Fred",Arrays.asList(talent2));
        dudeRepository.saveAll(Arrays.asList(dude1,dude2,dude3));

        Weapon lasgun = new Weapon("Lasgun","Basic",100,"S/3/-","1d10+3 E",0,60,"Full",75,"Reliable",dude1);
        Weapon boltgun = new Weapon("Boltgun","Basic",90,"S/2/-","1d10+5 X",4,24,"Full",500,"",dude2);
        Weapon chainsword = new Weapon("Chainsword","Melee",1,"","1d10+2 R",2,0,"",275,"Tearing",dude3);
        weaponRepository.saveAll(Arrays.asList(lasgun,boltgun,chainsword));
    }
}
