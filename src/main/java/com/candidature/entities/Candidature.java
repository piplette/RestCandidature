package com.candidature.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Candidature
 *
 */
@Entity
public class Candidature implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CANDIDATURE_ID")
	private int id;
	
	@Column(name = "DATE_INSCRIPTION", nullable = false)
	private Date dateInscription;
	
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	private Session session;
	
	@ManyToOne
	private Etat etat;
	
	@OneToOne
	private Candidat candidat;
	
	public Candidature() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public Date getDateInscription() {
		return this.dateInscription;
	}

	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
	}	

	public Session getSession() {
		return session;
	}
	public void setSession(Session session) {
		this.session = session;
	}
	public Etat getEtat() {
		return etat;
	}
	public void setEtat(Etat etat) {
		this.etat = etat;
	}
	public Candidat getCandidat() {
		return candidat;
	}
	public void setCandidat(Candidat candidat) {
		this.candidat = candidat;
	} 
}
