function panierAjax(ref, qte) {
	//alert("on est dans appel");
	
		// alert("AJAX request successfully completed");
	var xhr;
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) {
			// recuperation balise span 
			
			
			var json= 
			[
			  {"prixTotal": "10", 
			  "quantiteTotal": "5"
			}
			]			
			
//			var zonePrix = document.getElementById("modifPrix");
//			var zoneQuantiteTot = document.getElementById("modifQuantiteTot");
					
			if (xhr.status == 200) {
				// on remplit le corps du span avec ce qui vient du serveur
				var result = json.parse(xhr.responseText);
			//	var  result = resultAvecSeparateur.split("+");

				
				zonePrix.innerHTML = result[0];
				zoneQuantiteTot.innerHTML = result[1];
			
			}
		}
	};
	
	var dvd = JSON.parse(xhr.responseText); 
	for(var cle in dvd)
	{ div.innerHTML += cle + "-->" + dvd[cle] + "<br/>"; }

	xhr.open("GET", "ActionPanier?ref="+ref+"&qte="+qte, true);
	xhr.send(null);
}

function accueilAjax(ref, qte) {
	//alert("on est dans appel");
	
		// alert("AJAX request successfully completed");
	var xhr;
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) {
			// recuperation balise span 
			
			var zoneQuantiteTot = document.getElementById("modifQuantiteTot");
					
			if (xhr.status == 200) {
				// on remplit le corps du span avec ce qui vient du serveur
				zoneQuantiteTot.innerHTML = xhr.responseText;;
			
			}
		}
	};
	
	

	xhr.open("GET", "ActionArticle?ref="+ref, true);
	xhr.send(null);
}