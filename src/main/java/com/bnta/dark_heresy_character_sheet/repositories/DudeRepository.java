package com.bnta.dark_heresy_character_sheet.repositories;

import com.bnta.dark_heresy_character_sheet.models.Dude;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DudeRepository extends JpaRepository<Dude,Long> {
}
