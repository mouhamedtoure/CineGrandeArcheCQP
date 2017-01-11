package fr.demos.poe.projet.librairie.controleur;

import javax.inject.Inject;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import fr.demos.poe.projet.librairie.data.ArticleDAO;
import fr.demos.poe.projet.librairie.metier.Panier;

/**
 * Application Lifecycle Listener implementation class CineListener
 *
 */
@WebListener
public class CineListerner implements ServletContextListener, HttpSessionListener {

	@Inject private ArticleDAO dao;

	/**
	 * Default constructor.
	 */
	public CineListerner() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
	 */
	public void sessionCreated(HttpSessionEvent arg0) {

		Panier panier = new Panier();
		arg0.getSession().setAttribute("monPanier", panier);
		arg0.getSession().setAttribute("compteurPanier", panier.getCompteur());

	}

	/**
	 * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
	 */
	@SuppressWarnings("unused")
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub

		// Essayer de conserver le panier en memoire dans la base de donnees

		Panier panier = (Panier) arg0.getSession().getAttribute("monPanier");
	
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent arg0) {

		arg0.getServletContext().setAttribute("mesArticles", dao.select(""));

	}

}
