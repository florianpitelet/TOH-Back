package com.pitchup.heromanager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Console;
import java.io.Serializable;
import java.util.ArrayList;

@Entity
public class Team implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String nom;
    //? many to one necesssaire?
    @ManyToOne
    @JoinColumn(name = "hero_id")
    private Hero hero;

    public Hero getHero() {
        return hero;
    }

    ArrayList<Hero> tabTeam = new ArrayList<>();

    public Team() { super();}

    public Team(Long id, String nom){
        super();
        this.id = id;
        this.nom = nom;

    }

    public long getId() { return id; }
    public void setId(Long id){ this.id = id; }

    public String getNom(){ return nom; }
    public void setNom(String nom){ this.nom = nom;}

    //set tableau
    public void setTabTeam(Hero hero){
        this.tabTeam.add(hero);
    }
    //getTabTeam() recupere le tableau de heros d'une team
    public ArrayList<Hero> getTabTeam(){
        for (Hero heroItem: tabTeam){

            heroItem.getNom();
        }
        return tabTeam;
    }


    @Override
    public String toString() {return "Team [id=" + id + ", nom=" + nom + "]";}
}
