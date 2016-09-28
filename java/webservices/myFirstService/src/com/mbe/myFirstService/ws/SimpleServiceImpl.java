package com.mbe.myFirstService.ws;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

@WebService(endpointInterface="com.mbe.myFirstService.ws.ISimpleService")
public class SimpleServiceImpl implements ISimpleService {

	private List<Tache> taches;
	
	

	public SimpleServiceImpl() {
		taches = new ArrayList<Tache>();
		taches.add(new Tache(1, "faire les courses", 3));
		taches.add(new Tache(2, "inventer la teleportation", 3));
		taches.add(new Tache(3, "nettoyer la salle de bain", 3));
		taches.add(new Tache(4, "s'inscrire à koh lanta", 3));
	}


	@Override
	public String getSalutation(String name) {
		return "bonjour, "+ name + ", quel beau web service!";
	}


	
	@Override
	public Tache getTache(int id) {
		for (Tache t : taches) {
			if (t.getId() == id)
				return t;
		}
		return null;
	}


	@Override
	public Tache[] getTaches() {
		return taches.toArray(new Tache[] {});
	}

}
