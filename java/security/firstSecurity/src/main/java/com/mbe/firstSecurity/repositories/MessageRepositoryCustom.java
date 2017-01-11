package com.mbe.firstSecurity.repositories;

import java.util.List;

import com.mbe.firstSecurity.metier.Message;

public interface MessageRepositoryCustom {
	List<Message> findUnsecureByTitre(String titre);
	List<Message> findsecureByTitre(String titre);
}
