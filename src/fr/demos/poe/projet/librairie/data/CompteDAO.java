package fr.demos.poe.projet.librairie.data;

import fr.demos.poe.projet.librairie.metier.Compte;

public interface CompteDAO {
	
	void insert(String email, String motdepasse, String nom, String prenom, String adresse) throws Exception;
	void update(Compte c) throws Exception;
	void delete(Compte c) throws Exception;
	Compte select(String email, String motdepasse);

}
