package com.mbe.firstStrutsSpringJpa.actions;

import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mbe.firstStrutsSpringJpa.metier.Message;
import com.mbe.firstStrutsSpringJpa.repository.IMessageDAO;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class IndexAction extends ActionSupport implements ModelDriven<Message> {
	
	private static Logger log = LogManager.getLogger(ActionSupport.class); 
	private static final long serialVersionUID = 1L;

	private IMessageDAO messageDAO;
	public void setMessageDAO(IMessageDAO messageDAO) {
		this.messageDAO = messageDAO;
	}
	
	private List<Message> messages;
	public List<Message> getMessages() {
		return messages;
	}
	
	private Message model;
	@Override
	public Message getModel() {
		if (model == null){
			model = new Message();
		}
		return model;

	}
	
	public String index() {
		log.info("appel de index!");
		messages = messageDAO.findAll();
		return SUCCESS;
	}
	
	public String edit(){
		Message m = messageDAO.finfByID(getModel().getId());
		if (m == null)
			return "notfound";
		getModel().setTitre(m.getTitre());
		getModel().setCorps(m.getCorps());
		return SUCCESS;
	}
	
	public String save(){
		Message m = getModel();
		m = messageDAO.save(m);
		return SUCCESS;
	}
	
	public String create(){
		return SUCCESS;
	}
	
	public String remove(){
		messageDAO.remove(getModel().getId());
		return SUCCESS;
	}




}
