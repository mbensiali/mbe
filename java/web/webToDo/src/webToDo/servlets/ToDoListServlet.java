package webToDo.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webToDo.metier.Tache;

/**
 * Servlet implementation class ToDoListServlet
 */
public class ToDoListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToDoListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Tache> taches = (List<Tache>)getServletContext().getAttribute("taches");
		List<Tache> sortedList=new ArrayList<>(taches);
		Collections.sort(sortedList, (t1,t2) -> ((Integer)t2.getPriorite()).compareTo(t1.getPriorite()));
		request.setAttribute("taches", taches);
		getServletContext().getRequestDispatcher("/liste.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String description = request.getParameter("description");
		String categorie = request.getParameter("categorie");
		int priorite = Integer.parseInt(request.getParameter("priorite"));
		Tache newtache=new Tache(description,categorie,priorite);
		List<Tache> taches = (List<Tache>)getServletContext().getAttribute("taches");
		taches.add(newtache);
		doGet(request, response);				
	}

}
