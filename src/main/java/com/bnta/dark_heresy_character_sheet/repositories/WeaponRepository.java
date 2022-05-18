package com.bnta.dark_heresy_character_sheet.repositories;

import com.bnta.dark_heresy_character_sheet.models.Weapon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WeaponRepository extends JpaRepository<Weapon, Long> {

    List<Weapon> findWeaponByWeaponClassLike(String weaponClass);
    List<Weapon> findWeaponByCostGreaterThanEqual(Integer cost);
}
