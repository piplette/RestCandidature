package com.candidature.entities;

import java.io.Serializable;
import java.lang.String;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Etat
 *
 */
@Entity
public class Etat implements Serializable {
	   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ETAT_ID")
	private int id;
	@Column(nullable = false)
	private String nom;
	private static final long serialVersionUID = 1L;
	
	@OneToOne(mappedBy="etat") 
	private Candidature candidature;
	
	public Etat() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public Candidature getCandidature() {
		return candidature;
	}
	public void setCandidature(Candidature candidature) {
		this.candidature = candidature;
	}
}
