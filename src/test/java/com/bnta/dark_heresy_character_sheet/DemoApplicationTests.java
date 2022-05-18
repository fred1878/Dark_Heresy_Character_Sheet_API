package com.bnta.dark_heresy_character_sheet;

import com.bnta.dark_heresy_character_sheet.models.Weapon;
import com.bnta.dark_heresy_character_sheet.repositories.WeaponRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	WeaponRepository weaponRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void canFindWeaponByClass(){
		assertThat(weaponRepository.findWeaponByWeaponClass("Basic").size()).isEqualTo(2);
	}

	@Test
	public void canfindWeaponByCostGreaterThanEqual(){
		assertThat(weaponRepository.findWeaponByCostGreaterThanEqual(200).size()).isEqualTo(2);
	}

	@Test
	public void canQueryParamsTogether(){
		List<Weapon> query = new ArrayList<>(weaponRepository.findWeaponByWeaponClass("Basic"));
		query.addAll(weaponRepository.findWeaponByCostGreaterThanEqual(200));
		assertThat(query.size()).isEqualTo(2);
	}

}
