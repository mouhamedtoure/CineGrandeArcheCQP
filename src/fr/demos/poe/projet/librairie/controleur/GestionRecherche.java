package fr.demos.poe.projet.librairie.controleur;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.demos.poe.projet.librairie.data.ArticleDAO;
import fr.demos.poe.projet.librairie.data.ArticleDAOMySQL;

/**
 * Servlet implementation class GestionRecherche
 */
@WebServlet("/GestionRecherche")
public class GestionRecherche extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject private ArticleDAO dao;
	private static final String CHAMP_RECHERCHE = "rechercher";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GestionRecherche() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		Map<String, String> erreursR = new HashMap<String, String>();

		if (action != null && action.equals("Rechercher")) {

			String rechercher = request.getParameter(CHAMP_RECHERCHE);

			out.println(rechercher);

			try {

				validationRecherche(rechercher);

			} catch (Exception e) {

				String er1 = e.getMessage();
				erreursR.put(CHAMP_RECHERCHE, er1);

			}
			if (erreursR.isEmpty()) {

				request.setAttribute("erreursR", erreursR);

				try {
					// ArticleDAOMySQL articleDAO = new ArticleDAOMySQL();
					session.setAttribute("mesArticles", dao.select(rechercher));

				} catch (Exception e) {

					e.printStackTrace();
				}

			} else {

				request.setAttribute("erreursR", erreursR);
				RequestDispatcher rd = request.getRequestDispatcher("/AccueilVue.jsp");
				rd.forward(request, response);

			}

			RequestDispatcher rd = request.getRequestDispatcher("/RechercheVue.jsp");
			rd.forward(request, response);

		}
		
		

	}

	private void validationRecherche(String rechercher) throws Exception {

		if (rechercher != null && rechercher.trim().length() < 3) {

			throw new Exception("Mot recherché trop court veuillez compléter !");

		}
	}
}
