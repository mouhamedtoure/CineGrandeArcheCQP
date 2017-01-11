<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Accueil</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
<jsp:include page="/MenuInscription.jsp"/>
	

	<form id="rechercheArticle" action="GestionRecherche" method="POST">

		<label for="rechercher"></label> <input type="text"
			value="${Rechercher}" name="rechercher" /> <span class="rechercher"></span>
		<input type="submit" value="Rechercher" name="action" /> <span
			class="erreur"> ${erreursR['rechercher']} </span> <br>

	</form>
	<table>
		<c:forEach items="${mesArticles}" var="article">
			<tr>
				<td><img src="<c:url value='Images/${article.getImage()}'/>"
					width="168" height="268" /></td>


				<td>${article.nom}</td>
				<td><c:if
						test="${article.getClass().getSimpleName() == 'Livre' }"> ${article.auteur}  </c:if>
						
						<c:if
						test="${article.getClass().getSimpleName() == 'ArticleDivers' }"> ${article.caracteristique}  </c:if>
						
				<td>${article.prixHT}&euro;</td>

				<td> <c:if test="${not empty article.getMateriel()}"> Stock: ${article.getMateriel().stock} </c:if> </td>
				<td>
				
				</td>
				<td>
				
				</td>
				
				<td>	<form action="GestionArticle" method="post"> 

						<input type="hidden" name="Reference" value="${article.ref}" /> <input
							type="submit" value="Ajouter" name="action" />
							&nbsp; &nbsp;
							<input type="hidden" name="Reference" value="${article.ref}" /> <input
							type="submit" value="Details" name="action" />

					</form>
				
				<td>
				<span class="erreurs0">${erreurs0[article.ref]}</span>
			</tr>



		</c:forEach>

	</table>


</body>
</html>