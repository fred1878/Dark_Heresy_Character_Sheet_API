package com.bnta.dark_heresy_character_sheet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "dudes")
public class Dude {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String name;
    @Column
    @OneToMany(mappedBy = "dude", cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"dude"})
    private List<Weapon> weapons;

    @ManyToMany
    @JoinTable(
            name = "dudes_talents",
            joinColumns = {@JoinColumn(name = "dude_id", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "talent_id")}
    )
    @JsonIgnoreProperties({"dude"})
    private List<Talent> talents;

    public Dude() {}

    public Dude(String name,List<Talent> talents) {
        this.name = name;
        this.weapons = new ArrayList<>();
        this.talents = talents;
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

    public List<Talent> getTalents() {
        return talents;
    }

    public void setTalents(List<Talent> talents) {
        this.talents = talents;
    }
}
