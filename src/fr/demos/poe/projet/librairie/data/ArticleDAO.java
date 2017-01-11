package fr.demos.poe.projet.librairie.data;

import java.util.List;

import fr.demos.poe.projet.librairie.metier.Article;

public interface ArticleDAO {
	
	void insert(Article a) throws Exception;
	void update(Article a) throws Exception;
	void delete(Article a) throws Exception;
	List <Article> select(String critere); 


}
