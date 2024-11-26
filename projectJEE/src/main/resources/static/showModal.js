/**
 * Fonctions permettant l'affichage/fermeture du Modal (résumé d'un produit en popup propre)
 */

 function showModalOneProduct(row) {	
	
	/// Remplit (trouver comment le faire seulement sur le html avec thymeleaf):
    document.getElementById("modalId").textContent = row.getAttribute("data-id");
    document.getElementById("modalName").textContent = row.getAttribute("data-name");
    document.getElementById("modalOtherNames").textContent = row.getAttribute("data-otherNames").replace(/[\[\]]/g, "");
    document.getElementById("modalImage").src = row.getAttribute("data-picLink")
    document.getElementById("modalDescription").textContent = row.getAttribute("data-description");
    
    if(document.getElementById("modalShelfNumber").textContent != null){
		document.getElementById("modalShelfNumber").textContent = "n° " + row.getAttribute("data-stock");
		
	}else{
		document.getElementById("modalShelfNumber").textContent = "Unavailable";
	}
    
    
    // Pour l'icone du type :
    const myImg = document.getElementById("ProductTypeIcon");
    switch(row.getAttribute("data-type")){
		case "PLANT":
			myImg.src = '/img/plant.png'
			myImg.title = 'Plant/Root'
			break;
		case "WOOD":
			myImg.src = '/img/wood.png'
			myImg.title = 'Wood'
			break;
		case "FUNGUS":
			myImg.src = '/img/fungus.png'
			myImg.title = 'Mushroom/Fungus'
			break;
		case "ANIMAL_PART":
			myImg.src = '/img/insect.png'
			myImg.title = 'Animal/Insect Parts'
			break;
		default:
			myImg.src = '/img/other.png'
			myImg.title = 'Other Product'
	}
    		
    // Afficher la div du modal + fond
	document.getElementById("modalBackground").style.display = "block";
	document.getElementById("productModal").style.display = "block";
        
}

function closeModal() {
	document.getElementById("productModal").style.display = "none";
	document.getElementById("modalBackground").style.display = "none";
}
