package com.mbe.myUtilisateurMeteo.ws;

import javax.jws.WebService;

import com.mbe.myUtilisateurMeteo.metier.Utilisateur;

@WebService(endpointInterface="com.mbe.myUtilisateurService.ws.IUtilisateurService")
public class UtilisateurServiceImpl implements IUtilisateurService {
	
	private Utilisateur profil;

	@Override
	public Utilisateur getProfil() {
		return profil;
	}

}
