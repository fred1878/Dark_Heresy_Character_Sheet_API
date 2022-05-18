package com.bnta.dark_heresy_character_sheet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "playercharacters")
public class PlayerCharacter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String name;
    @Column
    @OneToMany(mappedBy = "playerCharacter")
    @JsonIgnoreProperties({"playerCharacter"})
    private List<Weapon> weapons;

    public PlayerCharacter() {}

    public PlayerCharacter(String name) {
        this.name = name;
        this.weapons = new ArrayList<>();
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

    public List<Weapon> getWeapons() {
        return weapons;
    }

    public void setWeapons(List<Weapon> weapons) {
        this.weapons = weapons;
    }
}
