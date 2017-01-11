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

        <form Method="post" action="GestionCompte">
	 
               
           
           
            <fieldset>

                <legend>Inscription</legend>
                
               <c:if test="${not empty erreursFormIns}">
                 <span class="erreur" > ${erreursFormIns['email']}</span> <br/>
				<span class="erreur"> ${erreursFormIns['motdepasse']}</span>
                </c:if>
                

                <p>Vous pouvez vous inscrire via ce formulaire.</p>


                <label for="monEmail">Adresse email <span class="requis">*</span> </label>

                <input type="text" id="email" name="email" value="${param.email}" size="20" maxlength="60" />

                <br />


                <label for="monMotdepasse">Mot de passe <span class="requis">*</span></label>

                <input type="password" id="motdepasse" name="motdepasse" value="${param.motdepasse}" size="20" maxlength="20" />

                <br />
				
                <label for="nom">Nom</label>

                <input type="text" id="nom" name="nom" value="${param.nom}" size="20" maxlength="20" />

                <br />
                
                <label for="nom">Prénom</label>

                <input type="text" id="prenom" name="prenom" value="${param.prenom}" size="20" maxlength="20" />

                <br />
                
                <label for="nom">Adresse</label>

                <input type="text" id="adresse" name="adresse" value="${param.adresse}" size="20" maxlength="20" />

                <br />
			

                <input type="submit" value="Inscription" class="sansLabel"  name="action"/>

                <br />
                
                        

            </fieldset>
            
            

        </form>


    </body>

</html>