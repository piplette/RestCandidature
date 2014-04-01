package com.candidature.web;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.RollbackException;

import org.eclipse.persistence.exceptions.TransactionException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.candidature.entities.*;

@Controller
@RequestMapping("/candidat")
public class CandidatController {

	private EntityManagerFactory emf;
	private EntityManager em;

	private void open() {
		emf = Persistence.createEntityManagerFactory("manager");
		em = emf.createEntityManager();
	}

	private void close() {
		em.close();
		emf.close();
	}

	/*****************************************/
	/***** RECHERCHER UN CANDIDATS PAR ID *****/
	/*****************************************/
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, consumes = "application/json")
	@ResponseBody
	public Candidat findCandidatById(@PathVariable("id") int candidatId) {
		open();
		Candidat candidat = null;
		try {
			candidat = em.find(Candidat.class, candidatId);
		} catch (EntityNotFoundException e) {
			System.out.println("personne non trouvée");
		} finally {
			close();
		}
		return candidat;
	}

	/*****************************************/
	/***** RECHERCHER TOUS LES CANDIDATS *****/
	/*****************************************/
	@RequestMapping(method = RequestMethod.GET, consumes = "application/json")
	@ResponseBody
	public List<Candidat> findAllCandidat(
			@RequestParam(value = "sujet", required = false) String sujet) {
		open();
		Query query = null;
		List<Candidat> candidats = null;
		try {
			query = em.createQuery("select c from Candidat c");
			candidats = query.getResultList();
			Iterator<Candidat> it = candidats.iterator();
			while (it.hasNext()) {
				System.out.println(it.next().toString());
			}
		} catch (EntityNotFoundException e) {
			System.out.println("erreur");
		} finally {
			close();
		}

		return candidats;
	}

	/****************************************/
	/***** ENREGISTREMENT D'UN CANDIDAT *****/
	/****************************************/
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Object> postMessage(@RequestBody Candidat candidat) {
		open();
		if (candidat.getAdresse() == null) { return new ResponseEntity<Object>("adresse vide", HttpStatus.BAD_REQUEST);} 
		if (candidat.getCodePostal() == null) { return new ResponseEntity<Object>("cp vide", HttpStatus.BAD_REQUEST);} 
		if (candidat.getDiplome() == null) { return new ResponseEntity<Object>("diplome vide", HttpStatus.BAD_REQUEST);} 
		if (candidat.getEmail() == null) { return new ResponseEntity<Object>("email vide", HttpStatus.BAD_REQUEST);}
		if (candidat.getNom() == null) { return new ResponseEntity<Object>("nom vide", HttpStatus.BAD_REQUEST);}
		if (candidat.getPassword() == null) { return new ResponseEntity<Object>("password vide", HttpStatus.BAD_REQUEST);}
		if (candidat.getPrenom() == null) { return new ResponseEntity<Object>("prenom vide", HttpStatus.BAD_REQUEST); } 
		if (candidat.getSituationFamiliale() == null) { return new ResponseEntity<Object>("sitFam vide", HttpStatus.BAD_REQUEST);}
		if (candidat.getTelephone() == null) { return new ResponseEntity<Object>("telephone vide", HttpStatus.BAD_REQUEST);}
		if (candidat.getVille() == null) { return new ResponseEntity<Object>("ville vide", HttpStatus.BAD_REQUEST);}
		try {
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			em.persist(candidat);
			tx.commit();
		} catch (RollbackException te) {
			close();
			return new ResponseEntity<Object>("Doublon", HttpStatus.CONFLICT);
		}
		close();
		return new ResponseEntity<Object>("OK", HttpStatus.CREATED);

	}

}
