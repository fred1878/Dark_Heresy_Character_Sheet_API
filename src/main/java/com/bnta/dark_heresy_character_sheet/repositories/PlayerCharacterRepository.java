package com.bnta.dark_heresy_character_sheet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerCharacterRepository extends JpaRepository<Character,Long> {
}
