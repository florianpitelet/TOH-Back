package com.pitchup.heromanager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Team implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String nom;

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

    @Override
    public String toString() {return "Team [id=" + id + ", nom=" + nom + "]";}
}
