package fr.demos.poe.projet.librairie.controleur;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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

import fr.demos.poe.projet.librairie.data.*;
import fr.demos.poe.projet.librairie.metier.*;

/**
 * Servlet implementation class GestionCompte
 */
@WebServlet("/GestionCompte")
public class GestionCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CHAMP_EMAIL = "email";
	private static final String CHAMP_MOTDEPASSE = "motdepasse";
	private static final String ERRFORM = "erreursForm";
	private static final String ERRFORMINS = "erreursFormIns";
	private static final String ERRAUTH = "erreursAuth";
	@Inject private ArticleDAO dao;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GestionCompte() {
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

		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		PrintWriter out = response.getWriter();

		Panier panier = (Panier) session.getAttribute("monPanier");

		Map<String, String> erreursForm = new HashMap<String, String>();
		ArrayList<String> erreursAuth = new ArrayList<>();

		if (action != null && action.equals("Inscription")) {

			String paramEmail = request.getParameter("email");
			String paramMotdepasse = request.getParameter("motdepasse");
			String paramNom = request.getParameter("nom");
			String paramPrenom = request.getParameter("prenom");
			String paramAdresse = request.getParameter("adresse");

			try {

				validationEmail(paramEmail);

			} catch (Exception e) {

				String er1 = e.getMessage();
				erreursForm.put(CHAMP_EMAIL, er1);

			}

			try {
				validationMotdepasse(paramMotdepasse);
			} catch (Exception e) {

				String er2 = e.getMessage();

				erreursForm.put(CHAMP_MOTDEPASSE, er2);

			}
			request.setAttribute(ERRFORMINS, erreursForm);

			if (erreursForm.isEmpty()) {

				try {

					CompteDAOMySQL compteDAO = new CompteDAOMySQL();
					compteDAO.insert(paramEmail, paramMotdepasse, paramNom, paramPrenom, paramAdresse);

				} catch (Exception e) {

					e.printStackTrace();
				}

				RequestDispatcher rd = request.getRequestDispatcher("/ValidationInscription.jsp");
				rd.forward(request, response);

			} else {

				RequestDispatcher rd = request.getRequestDispatcher("/InscriptionVue.jsp");
				rd.forward(request, response);
			}

		}

		if (action != null && action.equals("Deconnexion")) {

			session.invalidate();
			session = request.getSession();
			try {

				// ArticleDAOMySQL articleDAO = new ArticleDAOMySQL();
				session.setAttribute("mesArticles", dao.select(null));

			} catch (Exception e) {

				e.printStackTrace();
			}

			RequestDispatcher rd = request.getRequestDispatcher("/AccueilVue.jsp");
			rd.forward(request, response);

		}

		if (action != null && action.equals("Connexion")) {

			String email = request.getParameter(CHAMP_EMAIL);
			String motdepasse = request.getParameter(CHAMP_MOTDEPASSE);

			try {

				validationEmail(email);

			} catch (Exception e) {

				String er1 = e.getMessage();
				erreursForm.put(CHAMP_EMAIL, er1);

			}

			try {
				validationMotdepasse(motdepasse);
			} catch (Exception e) {

				String er2 = e.getMessage();

				erreursForm.put(CHAMP_MOTDEPASSE, er2);

			}

			request.setAttribute(ERRFORM, erreursForm);

			out.println(erreursForm);

			if (erreursForm.isEmpty()) {

				try {

					Authentification aut = new Authentification();

					Compte compteT = aut.login(email, motdepasse);

					panier.setCompte(compteT);

					session.setAttribute("monCompte", compteT);

				} catch (MyLoginException e) {

					erreursAuth.add(e.getMessage());

				}
				request.setAttribute(ERRAUTH, erreursAuth);

				if (erreursForm.isEmpty() && erreursAuth.isEmpty()) {

					RequestDispatcher rd = request.getRequestDispatcher("/CompteVue.jsp");
					rd.forward(request, response);
				} else {
					RequestDispatcher rd = request.getRequestDispatcher("/AccueilVue.jsp");
					rd.forward(request, response);
				}
			}

			else {

				RequestDispatcher rd = request.getRequestDispatcher("/AccueilVue.jsp");
				rd.forward(request, response);

			}
		}
	}

	private void validationEmail(String email) throws Exception {

		if (email != null && email.trim().length() != 0) {

			if (!email.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")) {

				throw new Exception("! Merci de saisir une adresse mail valide.");

			}

		} else {

			throw new Exception("! Merci de saisir une adresse mail.");

		}

	}

	private void validationMotdepasse(String motdepasse) throws Exception {

		if (motdepasse != null && motdepasse.trim().length() < 1) {

			throw new Exception("! Veuillez vérifier votre mot de passe");

		}
	}

}
