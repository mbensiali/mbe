package com.mbe.firstWebService.webservices;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import com.mbe.firstWebService.metier.Message;
import com.mbe.firstWebService.repositories.MessageRepository;

@WebService(endpointInterface="com.mbe.firstWebService.webservices.SalutationService")
public class SalutationServiceImpl implements SalutationService {
	
	@Autowired
	private MessageRepository messageRepository;


	@Override
	public String direBonjour(String nom) {
		return "bonjour,  " + nom; 
	}

	@Override
	public Message findMessageByID(int id) {
		return messageRepository.findOne(id);
	}

}
