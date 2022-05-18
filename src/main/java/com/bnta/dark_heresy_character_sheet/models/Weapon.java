package com.bnta.dark_heresy_character_sheet.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "weapons")
public class Weapon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String name;
    @Column
    private List<WeaponAttributes> weaponAttributes;
    @ManyToOne
    @JoinColumn(name = "character_id",nullable = false)
    private Character character;

    public Weapon() {}

    public Weapon(String name, List<WeaponAttributes> weaponAttributes, Character character) {
        this.name = name;
        this.weaponAttributes = weaponAttributes;
        this.character = character;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<WeaponAttributes> getWeaponAttributes() {
        return weaponAttributes;
    }

    public void setWeaponAttributes(List<WeaponAttributes> weaponAttributes) {
        this.weaponAttributes = weaponAttributes;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }
}
