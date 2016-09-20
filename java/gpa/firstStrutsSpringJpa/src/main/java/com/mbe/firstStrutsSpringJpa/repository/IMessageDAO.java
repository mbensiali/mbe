package com.mbe.firstStrutsSpringJpa.repository;

import java.util.List;

import com.mbe.firstStrutsSpringJpa.metier.Message;

public interface IMessageDAO {
	List<Message> findAll();
	Message finfByID(int id);
	Message save(Message m);
	void remove(int id);
	

}
