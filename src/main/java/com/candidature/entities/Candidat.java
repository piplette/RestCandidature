package com.candidature.entities;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Candidat
 *
 */
@Entity
public class Candidat implements Serializable {
	   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CANDIDAT_ID")
	private int id;
	
	@Column(nullable = false)
	private String nom;
	
	@Column(nullable = false)
	private String prenom;
	
	@Column(nullable = false, unique = true)
	private String telephone;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	@Column(nullable = false)
	private String diplome;
	
	@Column(name = "SITUATION_PRO", nullable = false)
	private String situationPro;
	
	@Column(name = "PASSWORD", nullable = false)
	private String password;
	
	private static final long serialVersionUID = 1L;
	
	@OneToOne(mappedBy="candidat") 
	private Candidature candidature;

	public Candidat() {
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
	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}   
	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}   
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getDiplome() {
		return this.diplome;
	}

	public void setDiplome(String diplome) {
		this.diplome = diplome;
	}
	
	public String getSituationPro() {
		return this.situationPro;
	}

	public void setSituationPro(String situationPro) {
		this.situationPro = situationPro;
	}
	
	public Candidature getCandidature() {
		return candidature;
	}
	
	public void setCandidature(Candidature candidature) {
		this.candidature = candidature;
	}
	
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
