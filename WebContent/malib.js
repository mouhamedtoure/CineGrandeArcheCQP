function panierAjax(ref, qte) {
	// alert("on est dans appel");
	
		// alert("AJAX request successfully completed");
	var xhr;
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) {
			// recuperation balise span
			
			var donnees = { 
				     "prixTotal"    :   panier.getPrixTotal(), 
				     "quantiteTotal"       :   panier.getCompteur(), 
				};
			alert(donnees.prixTotal);
		
		
// var zonePrix = document.getElementById("modifPrix");
// var zoneQuantiteTot = document.getElementById("modifQuantiteTot");
					
			if (xhr.status == 200) {
				// on remplit le corps du span avec ce qui vient du serveur
				var result = JSON.parse(xhr.responseText);
			// var result = resultAvecSeparateur.split("+");

				
				zonePrix.innerHTML= result[0];
				zoneQuantiteTot = result[1];
			
			}
		}
	};

	xhr.open("GET", "ActionPanier?ref="+ref+"&qte="+qte, true);
	xhr.send(null);
}

function accueilAjax(ref, qte) {
	// alert("on est dans appel");
	
		// alert("AJAX request successfully completed");
	var xhr;
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) {
			// recuperation balise span
			

			var donnees = { 
				     "prixTotal"    :   "0", 
				     "quantiteTotal"       :   "0", 
				};
			
			alert(donnees.prixTotal);
			
		// var zoneQuantiteTot = document.getElementById("modifQuantiteTot");
					
			if (xhr.status == 200) {
				// on remplit le corps du span avec ce qui vient du serveur
				// zoneQuantiteTot.innerHTML = xhr.responseText;;
				var result = JSON.parse(xhr.responseText);
				
				var zonePrix= result[0];
				var zoneQuantiteTot = result[1];
			}
		}
	};
	
	

	xhr.open("GET", "ActionArticle?ref="+ref, true);
	xhr.send(null);
}