package com.candidature.junit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.candidature.entities.Candidat;

public class CandidatTest {

    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		RestTemplate restTemplate = (RestTemplate)context.getBean("restTemplate");
		
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
    	String mot = "fdvfdssfds";
    	
    	Candidat candidat = new Candidat();
    	candidat.setAdresse(mot);
    	candidat.setCodePostal(78778);
    	candidat.setDiplome(mot);
    	candidat.setEmail(mot);
    	candidat.setMotivation(mot);
    	candidat.setNom(mot);
    	candidat.setPassword(mot);
    	candidat.setPrenom(mot);
    	candidat.setSituationPro(mot);
    	candidat.setTelephone(mot);
    	candidat.setVille(mot);
    	
    	
		HttpEntity<Candidat> entity = new HttpEntity<Candidat>(candidat,headers);
		String href = "http://localhost:8080/RestCandidature/candidat";
		
		restTemplate.exchange(href, HttpMethod.POST, entity, Candidat.class);
		
		
		
//		ResponseEntity<Candidat> response = restTemplate.exchange(href, HttpMethod.GET, entity, Candidat.class);
//		Candidat candidat = response.getBody();
//		System.out.println(candidat.toString());
    }
}
