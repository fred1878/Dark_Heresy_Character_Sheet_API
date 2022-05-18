package com.bnta.dark_heresy_character_sheet.components;

import com.bnta.dark_heresy_character_sheet.models.Dude;
import com.bnta.dark_heresy_character_sheet.repositories.DudesRepository;
import com.bnta.dark_heresy_character_sheet.repositories.WeaponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class Dataloader implements ApplicationRunner {

    @Autowired
    DudesRepository playerCharacterRepository;
    @Autowired
    WeaponRepository weaponRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Dude playerCharacter1 = new Dude("Venris");
        Dude playerCharacter2 = new Dude("Xanthis");
        Dude playerCharacter3 = new Dude("Fred");
        playerCharacterRepository.saveAll(Arrays.asList(playerCharacter1,playerCharacter2,playerCharacter3));
    }
}
