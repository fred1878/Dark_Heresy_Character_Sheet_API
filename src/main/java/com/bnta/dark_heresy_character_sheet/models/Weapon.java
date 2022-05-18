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
    private String pen;
    @Column
    private String clip;
    @Column
    private String rld;
    @Column
    private String cost;
    @Column
    private List<WeaponAttributes> weaponAttributes;
    @ManyToOne
    @JoinColumn(name = "character_id",nullable = false)
    private Character character;

    public Weapon() {}

    public Weapon(String name, String weaponClass, int range, String rof, String damage, String pen, String clip, String rld, String cost, List<WeaponAttributes> weaponAttributes, Character character) {
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

    public String getPen() {
        return pen;
    }

    public void setPen(String pen) {
        this.pen = pen;
    }

    public String getClip() {
        return clip;
    }

    public void setClip(String clip) {
        this.clip = clip;
    }

    public String getRld() {
        return rld;
    }

    public void setRld(String rld) {
        this.rld = rld;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
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
