package fr.demos.poe.projet.librairie.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.mysql.jdbc.Statement;

import fr.demos.poe.projet.librairie.metier.Compte;

public class CompteDAOMySQL implements CompteDAO {

	private Context context;
	private DataSource dataSource;

	public CompteDAOMySQL() throws Exception {

		context = new InitialContext();
		dataSource = (DataSource) context.lookup("java:comp/env/jdbc/CineGrandeArche");

	}

	@Override
	public void insert(String email, String motdepasse, String nom, String prenom, String adresse) throws Exception {
		// TODO Auto-generated method stub

		

		Connection cx = dataSource.getConnection();
		Statement statement = (Statement) cx.createStatement();


		/* Exécution d'une requête d'écriture */
		
		statement.executeUpdate("INSERT INTO  compte (email, motdepasse, nom, prenom, adresse) VALUES ('"+email+"','"+motdepasse+ "','"+nom+"','"+prenom+"','"+adresse+ "')");

	
		
		

	
	}

	@Override
	public void update(Compte c) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Compte c) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public Compte select(String email, String motdepasse) {

		Compte compte = null;
		try {
			Connection cx = dataSource.getConnection();

			// Prepared statement pour les donnees dans la table livre
			PreparedStatement contexteRequete = cx
					.prepareStatement("SELECT * FROM Compte WHERE email=? and motdepasse=?");
			contexteRequete.setString(1, email);
			contexteRequete.setString(2, motdepasse);
			
			ResultSet rs = contexteRequete.executeQuery();

			while (rs.next()) {


	

				String MonEmail = rs.getString("email");
				String MonMotdepasse = rs.getString("motdepasse");
				String MonNom= rs.getString("nom");
				String MonPrenom= rs.getString("prenom");
				String MonAdresse= rs.getString("adresse");
		
				
				compte = new Compte(MonEmail, MonMotdepasse, MonNom, MonPrenom, MonAdresse);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return compte;

	}

}
