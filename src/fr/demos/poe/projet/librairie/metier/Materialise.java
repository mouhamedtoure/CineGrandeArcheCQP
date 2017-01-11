package fr.demos.poe.projet.librairie.metier;

public class Materialise {

	private Integer stock;
	private double delaiLivraison;
	
	public Materialise(Integer stock, double delaiLivraison) {
		// TODO Auto-generated constructor stub
	
		this.stock=stock;
		this.delaiLivraison=delaiLivraison;
		
	}


	public double getDelaiLivraison() {
		return delaiLivraison;
	}

	public void setDelaiLivraison(double delai) {
		this.delaiLivraison = delai;
	}





	public Integer getStock() {
		return stock;
	}





	public void setStock(Integer stock) {
		this.stock = stock;
	}





	@Override
	public String toString() {
		return "Materialise [stock=" + stock + ", delai=" + delaiLivraison + "]";
	}


	
	
	
}
