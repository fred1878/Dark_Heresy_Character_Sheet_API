package com.bnta.dark_heresy_character_sheet.repositories;

import com.bnta.dark_heresy_character_sheet.models.Talent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TalentRepository extends JpaRepository<Talent, Long> {
}
