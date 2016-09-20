package hellowLogin.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("nom");
		String pass = request.getParameter("pass");
		
		System.out.println(nom);
		System.out.println(pass);
		if (nom == null || pass == null){
			getServletContext().getRequestDispatcher("/denied.jsp").forward(request, response);
		}
		else if((nom.equals("moi")) && (pass.equals("coucou"))){
				
			getServletContext().getRequestDispatcher("/succes.jsp").forward(request, response);			
		}
		else{
			
			getServletContext().getRequestDispatcher("/denied.jsp").forward(request, response);			
		}
		
	
	}

}
