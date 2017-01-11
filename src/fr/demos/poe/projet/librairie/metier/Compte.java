package fr.demos.poe.projet.librairie.metier;

public class Compte {

	private String email;
	private String motdepasse;
	private String nom;
	private String prenom;
	private String adresse;
	

	@Override
	public String toString() {
		return "Compte [email=" + email + ", motdepasse=" + motdepasse + ", nom=" + nom + ", prenom=" + prenom
				+ ", adresse=" + adresse + "]";
	}

	public Compte(String email, String motdepasse) {
		super();
		this.email = email;
		this.motdepasse = motdepasse;
	}

	public Compte(String email, String motDePasse, String nom, String prenom, String adresse) {
		this.email = email;
		this.motdepasse = motDePasse;
		this.nom=nom;
		this.prenom=prenom;
		this.adresse=adresse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotDePasse() {
		return motdepasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motdepasse = motDePasse;
	}

	public String getMotdepasse() {
		return motdepasse;
	}

	public void setMotdepasse(String motdepasse) {
		this.motdepasse = motdepasse;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


}
