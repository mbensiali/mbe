package com.mbe.spring_camelot.beans;

import java.util.Random;

public class QueteBuilder {
	private String[] ACTIONS = {"sauver", "casser la figure", "ramener", "consulter"};
	private String[] OBJETS = {"graal", "dame du lac", "monstre du lockness", "oracle"};
	
	public IQuete obtenirQuete(){
		QueteEpique quete = new QueteEpique();
		Random rd = new Random();
		quete.setDescription(ACTIONS[rd.nextInt(ACTIONS.length)] + " le/la/les " + OBJETS[rd.nextInt(OBJETS.length)]);
		quete.setDifficulte(rd.nextDouble());
		return quete;
	}
}
