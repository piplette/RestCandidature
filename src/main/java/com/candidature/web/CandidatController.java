package com.candidature.web;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;

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

//	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
//	@ResponseBody
//	public Candidat get(@PathVariable("id") int candidatId){
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("manager1");
//		EntityManager entityManager = emf.createEntityManager();
//		Candidat candidat = null;
////		EntityTransaction tx = entityManager.getTransaction();
////		tx.begin();
////		Candidat candidat = new Candidat();
////		candidat.setPrenomCandidat("Romain");
////		candidat.setNomCandidat("Parinaud");
////		Long tel = (long) 014631313;
////		candidat.setTelCandidat(tel);
////		candidat.setEmailCandidat("romparinaud@hotmail.com");
////		candidat.setDiplomeCandidat("nuuu");
////		entityManager.persist(candidat);
////		tx.commit();
//			
//		try {
//			candidat = entityManager.find(Candidat.class, candidatId);
////			System.out.println("Personne.nom=" + candidat.getNomCandidat());
//			} catch (EntityNotFoundException e) {
//			System.out.println("personne non trouvée");
//			}
//			entityManager.close();
//			emf.close();
//			
//			return candidat;
//	}
	
//	@RequestMapping(method = RequestMethod.GET)
//	@ResponseBody
//	@ResponseStatus(HttpStatus.OK)
//	public List<Message> getMessageSujet(@RequestParam(value="sujet", required = false) String sujet){
//		List<Message> messages = new ArrayList<Message>();
//		messages.add(new Message("Bonjour", "Tintin", "Affaire Tournesol"));
//		messages.add(new Message("Adieu", "Hadock", "Affaire Tournesol"));
//
//		return messages;
//	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public List<Candidat> getMessageSujet(@RequestParam(value="sujet", required = false) String sujet){	
		List<Candidat> candidats = new ArrayList<Candidat>();
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("manager");
	EntityManager entityManager = emf.createEntityManager();
	
//	EntityTransaction tx = entityManager.getTransaction();
//	tx.begin();
//	Candidat candidat = new Candidat();
//	candidat.setPrenomCandidat("Romain");
//	candidat.setNomCandidat("Parinaud");
//	Long tel = (long) 014631313;
//	candidat.setTelCandidat(tel);
//	candidat.setEmailCandidat("romparinaud@hotmail.com");
//	candidat.setDiplomeCandidat("nuuu");
//	entityManager.persist(candidat);
//	tx.commit();
		
	try {
		Candidat candidat = entityManager.find(Candidat.class, 1);
		candidats.add(candidat);
//		System.out.println("Personne.nom=" + candidat.getNomCandidat());
		} catch (EntityNotFoundException e) {
		System.out.println("Personne non trouvée");
		}
		entityManager.close();
		emf.close();
		
		return candidats;
	}	
	
//	@RequestMapping(method = RequestMethod.POST)
//	@ResponseStatus(HttpStatus.OK)
//	public void postMessage(@RequestBody Message message){
//		System.out.println(message);
//	}
}
