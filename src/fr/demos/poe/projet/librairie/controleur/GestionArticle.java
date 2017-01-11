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

// import fr.demos.poe.projet.librairie.data.*;
import fr.demos.poe.projet.librairie.metier.*;

/**
 * Servlet implementation class GestionArticle
 */
@WebServlet(name = "Accueil", urlPatterns = { "/GestionArticle" })
public class GestionArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GestionArticle() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		HttpSession session = request.getSession();
//
//		try {
//
//			ArticleDAOMySQL articleDAO = new ArticleDAOMySQL();
//			// session.setAttribute("mesArticles", articleDAO.select(null));
//
//		} catch (Exception e) {
//
//			e.printStackTrace();
//		}

		RequestDispatcher rd = request.getRequestDispatcher("/AccueilVue.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		RequestDispatcher rd = null;
		HttpSession session = request.getSession();
		Panier panier = (Panier) session.getAttribute("monPanier");
		@SuppressWarnings("unchecked")
		ArrayList<Article> articlesP = (ArrayList<Article>) session.getAttribute("mesArticles");

		String reference = request.getParameter("Reference");
		String action = request.getParameter("action");
		Map<String, String> erreurs0 = new HashMap<String, String>();

		if (action != null && action.equals("Details")) {

			for (Article a : articlesP) {

				if (a.getRef().equals(reference)) {

					int index = articlesP.indexOf(a);

					out.println(articlesP.get(index));

					request.setAttribute("ArticleAffiche", articlesP.get(index));
					rd = request.getRequestDispatcher("/DescriptionVue.jsp");

				}

			}

		}

		if (action != null && action.equals("Ajouter")) {

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
			if (panier.getCompte() == null) {

				rd = request.getRequestDispatcher("/AccueilVue.jsp");

			} 
			if(panier.getCompte()!=null)
				{
				rd = request.getRequestDispatcher("/CompteVue.jsp");

			}

		}
		session.setAttribute("compteurPanier", panier.getCompteur());
		rd.forward(request, response);
	}
}