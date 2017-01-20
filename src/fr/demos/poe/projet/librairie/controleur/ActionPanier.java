package fr.demos.poe.projet.librairie.controleur;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.demos.poe.projet.librairie.metier.Article;
import fr.demos.poe.projet.librairie.metier.Panier;

/**
 * Servlet implementation class ActionPanier
 */
@WebServlet("/ActionPanier")
public class ActionPanier extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ActionPanier() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int quantite = 0;
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		String reference = request.getParameter("Reference");
		// String action = request.getParameter("action");
		Panier panier = (Panier) session.getAttribute("monPanier");
		@SuppressWarnings("unchecked")
		ArrayList<Article> articlesP = (ArrayList<Article>) session.getAttribute("mesArticles");
		
		if (request.getParameter("quantity") != null) {

			quantite = Integer.parseInt(request.getParameter("quantity"));

		}
		Map<String, String> erreurs0 = new HashMap<String, String>();
		

		for (Article a : articlesP) {

			if (a.getRef().equals(reference)) {

				int index = articlesP.indexOf(a);

				try {

					panier.modifierQuantite(articlesP.get(index), quantite);

				} catch (IllegalArgumentException e1) {

					erreurs0.put(reference, e1.getMessage());

				}
				break;

			}

		}

		out.println(panier.getPrixTotal()+":"+quantite);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
