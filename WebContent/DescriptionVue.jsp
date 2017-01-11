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

<table>
		
			<tr>
				<td><img src="<c:url value='Images/${ArticleAffiche.getImage()}'/>"
					width="178" height="268" /></td>


				<td>${ArticleAffiche.nom}</td>
				<td><c:if
						test="${ArticleAffiche.getClass().getSimpleName() == 'Livre' }"> ${ArticleAffiche.auteur}  </c:if>
				<td>${ArticleAffiche.prixHT}&euro;</td>

				<td> <c:if test="${not empty ArticleAffiche.getMateriel()}"> Stock: ${ArticleAffiche.getMateriel().stock} </c:if>
					

						
				
			</tr>






	</table>
<strong>  <span style="text-decoration:underline;">	Description   </span> </strong>
<br>
<br>
<i> ${ArticleAffiche.getDescription()} </i>
 <br>
 <br>
	</body>
	</html> 