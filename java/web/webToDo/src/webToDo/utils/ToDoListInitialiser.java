package webToDo.utils;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import webToDo.metier.Tache;

/**
 * Application Lifecycle Listener implementation class ToDoListInitialiser
 *
 */
public class ToDoListInitialiser implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ToDoListInitialiser() {
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
    	List<Tache> taches = new ArrayList();
    	ctx.setAttribute("taches", taches);
    }
	
}
