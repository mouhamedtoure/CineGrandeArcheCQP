package fr.demos.poe.projet.librairie.metier;

public abstract class Article {

	private String reference;
	private double prixHT;
	private String nom;
	private String description;
	private String image;
	private Dematerialise demat;
	private Materialise materiel;
	private Etat etat;

	// Constructeur d'un article demateralise

	public Article(String ref, double prixHT, String nom, String description, String image, String format, String url) {
		super();
		this.reference = ref;
		this.prixHT = prixHT;
		this.nom = nom;
		this.description=description;
		this.image= image;
		this.demat = new Dematerialise(format, url);


	}

	// Constructeur d'un article materialise 

	public Article(String ref, double prixHT, String nom, String description, String image,  Etat etat, int stock, double delaiLivraison) {

		super();
		this.reference = ref;
		this.prixHT = prixHT;
		this.nom = nom;
		this.description=description;
		this.etat=etat;
		this.materiel = new Materialise(stock, delaiLivraison);
		this.image=image;

	}



	public String getRef() {
		return reference;
	}

	public void setRef(String ref) {
		this.reference = ref;
	}

	public double getPrixHT() {
		return prixHT;
	}

	public void setPrixHT(double prixHT) {
		this.prixHT = prixHT;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Etat getEtat() {
		return etat;
	}

	public void setEtat(Etat etat) {
		this.etat = etat;
	}

	@Override
	public String toString() {
		return  nom +","+ " prixHT=" + prixHT +" " ;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((reference == null) ? 0 : reference.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Article other = (Article) obj;
		if (reference == null) {
			if (other.reference != null)
				return false;
		} else if (!reference.equals(other.reference))
			return false;
		return true;
	}

	public Dematerialise getDemat() {
		return demat;
	}

	public void setDemat(Dematerialise demat) {
		this.demat = demat;
	}

	public Materialise getMateriel() {
		return materiel;
	}

	public void setMateriel(Materialise materiel) {
		this.materiel = materiel;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	
	
	
}
