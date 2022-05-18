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
    private String weaponClass;
    @Column
    private int range;
    @Column
    private String rof;
    @Column
    private String damage;
    @Column
    private int pen;
    @Column
    private int clip;
    @Column
    private String rld;
    @Column
    private int cost;
    @Column
    private String weaponAttributes;
    @ManyToOne
    @JoinColumn(name = "dude_id",nullable = false)
    private Dude dude;

    public Weapon() {}

    public Weapon(String name, String weaponClass, int range, String rof, String damage, int pen, int clip, String rld,
                  int cost, String weaponAttributes, Dude dude) {
        this.name = name;
        this.weaponClass = weaponClass;
        this.range = range;
        this.rof = rof;
        this.damage = damage;
        this.pen = pen;
        this.clip = clip;
        this.rld = rld;
        this.cost = cost;
        this.weaponAttributes = weaponAttributes;
        this.dude = dude;
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

    public String getWeaponClass() {
        return weaponClass;
    }

    public void setWeaponClass(String weaponClass) {
        this.weaponClass = weaponClass;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public String getRof() {
        return rof;
    }

    public void setRof(String rof) {
        this.rof = rof;
    }

    public String getDamage() {
        return damage;
    }

    public void setDamage(String damage) {
        this.damage = damage;
    }

    public int getPen() {
        return pen;
    }

    public void setPen(int pen) {
        this.pen = pen;
    }

    public int getClip() {
        return clip;
    }

    public void setClip(int clip) {
        this.clip = clip;
    }

    public String getRld() {
        return rld;
    }

    public void setRld(String rld) {
        this.rld = rld;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getWeaponAttributes() {
        return weaponAttributes;
    }

    public void setWeaponAttributes(String weaponAttributes) {
        this.weaponAttributes = weaponAttributes;
    }

    public Dude getDude() {
        return dude;
    }

    public void setPlayerCharacter(Dude dude) {
        this.dude = dude;
    }
}
