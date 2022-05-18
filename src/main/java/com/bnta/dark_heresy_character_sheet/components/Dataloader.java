package com.bnta.dark_heresy_character_sheet.components;

import com.bnta.dark_heresy_character_sheet.models.PlayerCharacter;
import com.bnta.dark_heresy_character_sheet.repositories.PlayerCharacterRepository;
import com.bnta.dark_heresy_character_sheet.repositories.WeaponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class Dataloader implements ApplicationRunner {

    @Autowired
    PlayerCharacterRepository characterRepository;
    @Autowired
    WeaponRepository weaponRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        PlayerCharacter playerCharacter1 = new PlayerCharacter("Venris");
        PlayerCharacter playerCharacter2 = new PlayerCharacter("Xanthis");
        PlayerCharacter playerCharacter3 = new PlayerCharacter("Fred");
        characterRepository.save(playerCharacter1);
    }
}
