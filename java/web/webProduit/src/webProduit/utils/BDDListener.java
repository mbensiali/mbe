package webProduit.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Application Lifecycle Listener implementation class BDDListener
 *
 */
public class BDDListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public BDDListener() {
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
    	try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("connection � la base produit");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/base_produitmanager", "root", "");
			System.out.println("connection r�ussie");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
}
