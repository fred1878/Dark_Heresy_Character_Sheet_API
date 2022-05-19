package com.bnta.dark_heresy_character_sheet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "talents")
public class Talent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String name;
    @Column
    private String desc;
    @ManyToMany(mappedBy = "talents")
    @JsonIgnoreProperties({"talents","weapons"})
    private List<Dude> dudes;


    public Talent() {}

    public Talent(String name, String desc) {
        this.name = name;
        this.desc = desc;
        this.dudes = new ArrayList<>();
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<Dude> getDudes() {
        return dudes;
    }

    public void setDudes(List<Dude> dudes) {
        this.dudes = dudes;
    }
}
