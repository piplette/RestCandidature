package com.candidature.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Etat
 *
 */
@Entity
public class Etat implements Serializable {
	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ETAT_ID")
	private int id;
	
	@Column(nullable = false)
	private String nom;
	
	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy="etat") 
	private Collection<Candidature> candidatures = new ArrayList<Candidature>();
	
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
	
	public Collection<Candidature> getCandidatures() {
		return candidatures;
	}
	
	public void setCandidatures(Collection<Candidature> candidatures) {
		this.candidatures = candidatures;
	}
}
