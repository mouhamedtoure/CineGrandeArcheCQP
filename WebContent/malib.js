function panierAjax(ref, qte) {
	// alert("on est dans appel");

	// alert("AJAX request successfully completed");
	var xhr;
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) {
			// recuperation balise span

			// var zonePrix = document.getElementById("modifPrix");
			// var zoneQuantiteTot =
			// document.getElementById("modifQuantiteTot");

			if (xhr.status == 200) {
				// on remplit le corps du span avec ce qui vient du serveur
				var zoneQuantiteTot = document.getElementById("quantiteTotal");
				var zonePrixTot = document.getElementById("prixTotal");
				// var result = resultAvecSeparateur.split("+");

				var objetJSON = JSON.parse(xhr.responseText);
				zoneQuantiteTot.innerHTML = objetJSON.quantiteTotal;
				zonePrixTot.innerHTML = objetJSON.prixTotal;

			}
		}
	};

	xhr.open("GET", "ActionPanier?ref=" + ref + "&qte=" + qte, true);
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

			var zoneQuantiteTot = document.getElementById("quantiteTotal");
		

			if (xhr.status == 200) {
				// on remplit le corps du span avec ce qui vient du serveur
				// zoneQuantiteTot.innerHTML = xhr.responseText;;
				var objetJSON = JSON.parse(xhr.responseText);
				zoneQuantiteTot.innerHTML = objetJSON.quantiteTotal;
				
			}
		}
	};

	xhr.open("GET", "ActionArticle?ref=" + ref, true);
	xhr.send(null);
}