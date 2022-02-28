package com.pitchup.heromanager.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Hero implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private long id;
	private String nom;
	private String pouvoir;
	
	public Hero() {
		super();
	}

	public Hero(long id, String nom, String pouvoir) {
		super();
		this.id = id;
		this.nom = nom;
		this.pouvoir = pouvoir;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPouvoir() {
		return pouvoir;
	}

	public void setPouvoir(String pouvoir) {
		this.pouvoir = pouvoir;
	}

	@Override
	public String toString() {
		return "Hero [id=" + id + ", nom=" + nom + ", pouvoir=" + pouvoir + "]";
	}
	
	
	
}
