/**
 * Fonctions permettant l'affichage/fermeture du Modal (résumé d'un produit en popup propre)
 */

 function showModalOneProduct(row) {	
	console.log("Id récup : " + row.getAttribute("data-id" ) );
	console.log("Name récup : " + row.getAttribute("data-name") );
	console.log("Autre noms : " + row.getAttribute("data-otherNames") );
	console.log("Descript récup : " + row.getAttribute("data-description") );
	console.log("Type : " + row.getAttribute("data-type") );	
	console.log("Lien img : " + row.getAttribute("data-picLink") );	
	console.log("Stock : " + row.getAttribute("data-stock") );
	
    /// Remplit:
    document.getElementById("modalId").textContent = row.getAttribute("data-id");
    document.getElementById("modalName").textContent = row.getAttribute("data-name");
    document.getElementById("modalOtherNames").textContent = row.getAttribute("data-otherNames").replace(/[\[\]]/g, "");
    document.getElementById("modalImage").src = row.getAttribute("data-picLink")
    document.getElementById("modalDescription").textContent = row.getAttribute("data-description");
    document.getElementById("modalShelfNumber").textContent = "n° " + row.getAttribute("data-stock");
    
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
