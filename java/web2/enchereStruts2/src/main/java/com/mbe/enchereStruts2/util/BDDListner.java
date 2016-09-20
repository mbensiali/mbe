package com.mbe.enchereStruts2.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Application Lifecycle Listener implementation class BDDListner
 *
 */
public class BDDListner implements ServletContextListener {

	
	// je récupere un logger, qui me permettra d'envoyer
	// des messages dans les logs de l'application
	// nous utilisons ici la librairie log4j
	// la classe en parametre premettra d'indiquer dans le log la provenance du message
	private Logger log = LogManager.getLogger(BDDListner.class);
	
    /**
     * Default constructor. 
     */
    public BDDListner() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
    	ServletContext ctx = arg0.getServletContext();
    	try {
			Class.forName(ctx.getInitParameter("bddDriverClass"));
			Connection connection = DriverManager.getConnection(
					ctx.getInitParameter("bddUrl"),
					ctx.getInitParameter("bddLogin"),
					ctx.getInitParameter("bddpassword"));
			
			log.info("connection a la base reussie");
			// instanciation du DAO des messages
			EnchereDAO enchereDAO = new EnchereDAO(connection);
			// stockage de ce dao dans le contexte de la webapp
			// a disposition du qui en aura besoin
			ctx.setAttribute("enchereDAO", enchereDAO);
	
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			log.error(e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.error(e);
		}
    }	


}
