package com.mbe.firstStrutsSpringJpa.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.mbe.firstStrutsSpringJpa.metier.Message;

public class MessageDAO implements IMessageDAO {


	@PersistenceContext
	private EntityManager em;
	public EntityManager getEm() {
		return em;
	}
	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	@Transactional
	public List<Message> findAll() {
		return em.createQuery("select m from Message as m", Message.class).getResultList();
	}

	@Override
	@Transactional
	public Message finfByID(int id) {
		return em.find(Message.class, id);
	}

	@Override
	@Transactional
	public Message save(Message m) {
		Message existing = em.find(Message.class, m.getId());
		if (existing != null){
			existing = em.merge(m);
		}
		else{
			em.persist(m);
			existing = m;
		}
		return existing;
	}

	@Override
	@Transactional
	public void remove(int id) {
		Message existing = em.find(Message.class, id);
		if(existing != null){
			em.remove(existing);
		}

	}

}
