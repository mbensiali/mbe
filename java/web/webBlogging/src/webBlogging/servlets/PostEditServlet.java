package webBlogging.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webBlogging.metier.Post;
import webBlogging.utils.PostDAO;

/**
 * Servlet implementation class PostEditServlet
 */
public class PostEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		PostDAO postdao = (PostDAO)getServletContext().getAttribute("postDAO");
		List<Post> posts = postdao.findAll();
		
		request.setAttribute("posts", posts);
		getServletContext().getRequestDispatcher("/liste.jsp").forward(request, response);
		
		String action = request.getParameter("action");
		switch(action) {
			case "creer post":
				Post p = new Post(0, "","" ,"" ,"");
				request.setAttribute("post", p);
				getServletContext().getRequestDispatcher("/liste.jsp").forward(request, response);
				break;
			case "editer post":
				Post p2 = postdao.findByID(Integer.parseInt(request.getParameter("id")));
				request.setAttribute("post", p2);
				getServletContext().getRequestDispatcher("/liste.jsp").forward(request, response);
				break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
