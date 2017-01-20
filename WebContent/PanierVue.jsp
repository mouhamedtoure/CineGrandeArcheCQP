<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Votre Panier</title>
<link href="style.css" rel="stylesheet" type="text/css">


<script>
function panierAjax() {
	//alert("on est dans appel");
	
		// alert("AJAX request successfully completed");
	var xhr;
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) {
			// recuperation balise span 
			
			var  result1= document.getElementById("affichagePrix");
		//	var  result2= document.getElementById("PrixTotal");
			
			
			
			if (xhr.status == 200) {
				// on remplit le corps du span avec ce qui vient du serveur
				mesModifs.innerHTML = xhr.responseText;
			}
		}
	};
	
	var modif= document.getElementById('modifQuantite').value;
	xhr.open("GET", "ActionPanier?modifQuantite="+ modif, true);
	xhr.send();
}
</script>
</head>
<body>

	<jsp:include page="/MenuInscription.jsp" />


	<form id="rechercheArticle" action="GestionRecherche" method="POST">

		<label for="rechercher"></label> <input type="text"
			value="${Rechercher}" name="rechercher" /> <span class="rechercher"></span>
		<input type="submit" value="Rechercher" name="action" /> <span
			class="erreur"> ${erreursR['rechercher']} </span> <br>

	</form>

	<br /> Voici votre panier! Vous disposez de
	${monPanier.getNbArticles()} article(s) &nbsp;
	<form id="viderPanier" action="GestionPanier" method="POST">
		<input type="submit" value="Vider" name="action" />

	</form>


	<c:if test="${not empty monPanier}">
		<c:if test="${monPanier.getNbArticles()!=0}">

			<table>



				<tr>
					<th>Article &nbsp;</th>

					<th>Titre &nbsp;</th>

					<th>Choix quantité &nbsp;</th>

					<th>Quantité &nbsp;</th>

					<th>Prix à l'unité &nbsp;</th>

					<th>Suppression &nbsp;</th>

				
					<td> <span id="affichagePrix">  </span></td> 

				</tr>



				<c:forEach items="${monPanier.getListeAchat()}" var="lignePanier">
					<tr>
						<td><img
							src="<c:url value='Images/${lignePanier.article.getImage()}'/>"
							width="178" height="268" /></td>




						<td>${lignePanier.article.nom}
							<form action="ActionPanier" method="post">
								<input type="hidden" name="ModifierArticle"
									value="${lignePanier.article.ref}">

							</form>
						</td>

						<td><c:if
								test="${not empty lignePanier.article.getMateriel()}">
								<form action="ActionPanier" method=post>
									<input type="hidden" name="Reference"
										value="${lignePanier.article.ref}" /> <input type="number"
										name="quantity" value="${lignePanier.quantite}" step="1"
										min="0" max="${lignePanier.article.getMateriel().stock}">
									<input type="button" id="modifQuantite" onclick="panierAjax();" value="Modifier" name="action">
								</form>

							</c:if></td>


						<td>${lignePanier.quantite}</td>
						<td>${lignePanier.article.prixHT}&euro;</td>
						<td>


							<form id="supprimerArticle" action="GestionPanier" method="POST">
								<input type="hidden" name="Reference"
									value="${lignePanier.article.ref}" /> <input type="submit"
									value="Supprimer" name="action" />

							</form>

						</td>
					</tr>

				</c:forEach>

			</table>
		</c:if>
	</c:if>

</body>
</html>

<!-- 


	 -->