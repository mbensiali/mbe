package com.mbe.secondSecurity.repositories;

import java.util.List;

import com.mbe.secondSecurity.metier.Message;



public interface MessageRepositoryCustom {
	List<Message> findUnsecureByTitre(String titre);
	List<Message> findsecureByTitre(String titre);
}
