package fr.demos.poe.projet.librairie.metier;

public class StockException extends Exception {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Article article;
	public int stockRestant;

	public StockException(Article article, Integer stockRestant, String message) {

		super(message);
		this.article = article;
		this.stockRestant = stockRestant;

	}

	public Article getArticle() {
		return article;
	}
	
	
	

}
