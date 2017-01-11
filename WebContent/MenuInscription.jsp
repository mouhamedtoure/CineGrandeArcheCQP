<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="header">


		<a id="accueil" href="AccueilVue.jsp"> <strong>Cine
				Grande Arche </strong></a>
	
<c:choose>
<c:when test="${not empty monPanier.getCompte()}">
		
		<form id="identification" action="GestionCompte" method="POST">
			<input type="submit" value="Deconnexion" name="action" /> Bienvenue ${monCompte.getPrenom()}!

		</form>

</c:when>
<c:otherwise>
		<form id="identification" action="GestionCompte" method="POST">
			<label for="email">Adresse email</label> <input type="text"
				value="${param.email}" name="email" /> <span class="erreur">${erreursForm['email']}</span>
			<label for="motdepasse">Mot de passe</label> <input type="password"
				value="${param.motdepasse}" name="motdepasse" /> <span
				class="erreur">${erreursForm['motdepasse']}</span> <input
				type="submit" value="Connexion" name="action" />
			<c:if test="${not empty erreursAuth}">
				<span class="erreur"> ${erreursAuth} </span>
			</c:if>
			&nbsp; <a id="inscrire" href="InscriptionVue.jsp"> <strong> S'incrire</strong></a>

		</form>
		
</c:otherwise>

</c:choose>

		<a id="panier" href="PanierVue.jsp"> Panier (${compteurPanier})</a>

	</div>
</body>
</html>