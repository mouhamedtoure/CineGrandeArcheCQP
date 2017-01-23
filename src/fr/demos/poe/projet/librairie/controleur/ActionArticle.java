package fr.demos.poe.projet.librairie.controleur;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.demos.poe.projet.librairie.metier.Article;
import fr.demos.poe.projet.librairie.metier.Panier;
import fr.demos.poe.projet.librairie.metier.StockException;

/**
 * Servlet implementation class ActionArticle
 */
@WebServlet("/ActionArticle")
public class ActionArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActionArticle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		String reference = request.getParameter("ref");
		// String action = request.getParameter("action");
		Panier panier = (Panier) session.getAttribute("monPanier");
		Map<String, String> erreurs0 = new HashMap<String, String>();
		@SuppressWarnings("unchecked")
		ArrayList<Article> articlesP = (ArrayList<Article>) session.getAttribute("mesArticles");
		
		

			// le panier existe peut-être déjà , utiliser une session

		
		
		for (Article a : articlesP) {

				if (a.getRef().equals(reference)) {

					int index = articlesP.indexOf(a);

					try {
						panier.ajouterArticle(articlesP.get(index), 1);

					} catch (StockException e1) {

						erreurs0.put(reference, e1.getMessage());
						request.setAttribute("erreurs0", erreurs0);
					}

					break;

				}
				
			}
		
			
			
		String jsonData = request.getParameter("donnees");  
		 System.out.println(jsonData) ;

			

		}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
