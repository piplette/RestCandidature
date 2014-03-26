package com.candidature.web;

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

import org.springframework.http.HttpStatus;
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
	/***** RECHERCHER UN CANDIDATS PAR ID*****/
	/*****************************************/
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Candidat findCandidatById(@PathVariable("id") int candidatId) {
		open();
		Candidat candidat = null;
		try {
			candidat = em.find(Candidat.class, candidatId);
		} catch (EntityNotFoundException e) {
			System.out.println("personne non trouvée");
		}finally{
			close();
		}
		return candidat;
	}

	/*****************************************/
	/***** RECHERCHER TOUS LES CANDIDATS *****/
	/*****************************************/
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public List<Candidat> findAllCandidat(
			@RequestParam(value = "sujet", required = false) String sujet) {
		open();
		Query query = null;
		try {
			query = em.createQuery("select c from Candidat c");
		} catch (EntityNotFoundException e) {
			System.out.println("erreur");
		}finally{
			close();
		}
		List<Candidat> candidats = query.getResultList();
		Iterator<Candidat> it = candidats.iterator();
		while(it.hasNext()){
			System.out.println(it.next().toString());
		}
		
	    return candidats;
	}
	/****************************************/
	/***** ENREGISTREMENT D'UN CANDIDAT *****/
	/****************************************/
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public void postMessage(@RequestBody Candidat candidat) {
		open();
		try{
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			em.persist(candidat);
			tx.commit();
		}catch(EntityExistsException e){
			e.printStackTrace();
		}finally{
			close();	
		}
	}
}
