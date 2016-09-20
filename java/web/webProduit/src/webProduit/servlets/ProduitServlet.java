package webProduit.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webProduit.metier.Produit;

/**
 * Servlet implementation class ProduitServlet
 */
public class ProduitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProduitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Produit> produits = (List<Produit>)getServletContext().getAttribute("produits");
		request.setAttribute("produits", produits);
		getServletContext().getRequestDispatcher("/produit.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");
		
		List<Produit> produits = (List<Produit>)getServletContext().getAttribute("produits");
		
		if (action != null && action.equals("supprimer")) {

			String name = request.getParameter("nom");
			produits.removeIf(p -> p.getNom().equals(name));
		}
		else {
			
			String nom = request.getParameter("nom");
			double prix = Double.parseDouble(request.getParameter("prix"));
			double poids = Double.parseDouble(request.getParameter("poids"));
			double stock = Double.parseDouble(request.getParameter("stock"));
			
			//Produit newProduit = new Produit(Integer.parseInt(request.getParameter("id")),nom, prix, poids, stock);
		
			//produits.add(newProduit);
			
		}
		

		doGet(request, response);
	}

}
