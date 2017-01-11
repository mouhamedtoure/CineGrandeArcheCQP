package fr.demos.poe.projet.librairie.metier;

import java.util.ArrayList;
import java.util.Iterator;

import javax.enterprise.context.SessionScoped;

@SessionScoped
public class Panier {

	private Compte compte;
	private ArrayList<LignePanier> lignesPanier = new ArrayList<LignePanier>();

	public Panier() {

	}

	public Panier(Compte compte) {

		this.compte = compte;

	}

	public void ajouterArticle(Article a, int quantite) throws StockException {

		// Initialisation d'un nouveau panier avec les paramètres en argument
		LignePanier lp = new LignePanier(a, quantite);

		// l'article était déjà dans le panier
		if (this.lignesPanier.contains(lp)) {

			// On stocke l'index de l'article dans une variable

			int index = lignesPanier.indexOf(lp);

			int quantiteArticlePanier = this.lignesPanier.get(index).getQuantite();

			// Test si l'article est matérialisé

			if (a.getDemat() == null) {

				// On teste pour voir si le stock est superieur a la quantite

				if (quantiteArticlePanier < a.getMateriel().getStock()) {

					// On augmente la quantite dans le panier
					int quantiteL = lignesPanier.get(index).getQuantite();
					lignesPanier.get(index).setQuantite(quantiteL + quantite);

				}

				// Sinon le stock est inferieur a la quantite
				else {

					StockException se = new StockException(a, a.getMateriel().getStock(),
							"La quantite demandee est superieure au stock disponible");

					throw se;
				}
			}
			// Sinon l'article est dématérialisé
			else {

				// On n'augmente pas la quantite
				
//				int quantiteL = lignesPanier.get(index).getQuantite();
//				lignesPanier.get(index).setQuantite(quantiteL + quantite);
			}

		}
		// Sinon nouvel article à ajouter au panier
		else {

			// Si l'article est matérialisé

			if (a.getDemat() == null) {

				// Si le stock dispo est inferieur a la quantite

				if (a.getMateriel().getStock() < quantite) {

					StockException se = new StockException(a, a.getMateriel().getStock(),
							"La quantite demandee est superieure au stock disponible");

					throw se;

				}

				// Sinon on ajoute au panier

				else {

					this.lignesPanier.add(lp);

				}

			}
			// Sinon l'article est dematerialise
			else {
				this.lignesPanier.add(lp);

			}
		}

	}

	public void supprimerArticle(Article a) {

		int quantite = 0;
		LignePanier lp = new LignePanier(a, quantite);

		if (this.lignesPanier.contains(lp)) {

			this.lignesPanier.remove(lp);

		}

	}

	public void modifierQuantite(Article a, int quantite) throws IllegalArgumentException {

		if (quantite < 0) {
			IllegalArgumentException qe = new IllegalArgumentException("Quantite saisie non autorisee");

			throw qe;
		}

		LignePanier lpArticleRecherche = new LignePanier(a, quantite);
		if (this.lignesPanier.contains(lpArticleRecherche)) {
			int index = this.lignesPanier.indexOf(lpArticleRecherche);

			this.lignesPanier.get(index).setQuantite(quantite);

		}
		if(quantite==0){
			
			supprimerArticle(a);
			
		}

	}

	public void vider() {

		this.lignesPanier.clear();

	}

	// retourner plutôt un iterator

	public Iterator<LignePanier> getListeAchat() {

		Iterator<LignePanier> iter = this.lignesPanier.iterator();
		return iter;

	}

	public Compte getCompte() {
		return compte;
	}
	
	

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	@Override

	public String toString() {

		return lignesPanier + "\n";

	}

	public double getPrixTotal() {

		double prixTotal = 0;

		for (LignePanier lp : this.lignesPanier) {

			prixTotal += lp.getArticle().getPrixHT() * lp.getQuantite();
		}

		prixTotal = Math.rint(prixTotal*100)/100;
		return prixTotal;
	}

	public int getCompteur() {
		int compteur = 0;
		for (LignePanier lp : this.lignesPanier) {

			compteur += lp.getQuantite();

		}

		return compteur;
	}

	public int getNbArticles() {
		int nbArticles = 0;
		for (Iterator<LignePanier> iterator = this.lignesPanier.iterator(); iterator.hasNext();) {
			iterator.next();
			nbArticles++;
		}
		return nbArticles;

	}
}
