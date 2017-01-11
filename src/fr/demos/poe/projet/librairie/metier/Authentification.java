package fr.demos.poe.projet.librairie.metier;

import fr.demos.poe.projet.librairie.data.*;

public class Authentification {

	public Authentification() {

	}

	public Compte login(String email, String motdepasse) throws MyLoginException {

		CompteDAOMySQL compteR;
		Compte monCompte = null;
		
	
		try {
			compteR = new CompteDAOMySQL();
			monCompte = compteR.select(email, motdepasse);

		} catch (Exception e1) {

			e1.printStackTrace();
		}
		if (monCompte == null) {

			throw new MyLoginException("Veuillez réessayer, l'authentification a échoué");

		}
		return monCompte;
	
	}


}
