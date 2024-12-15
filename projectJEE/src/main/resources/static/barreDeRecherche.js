const searchInput = document.getElementById("search");
const suggestionsBox = document.getElementById("suggestionsBox"); 

searchInput.addEventListener("input", () => {
    const query = searchInput.value.trim();
    
	if (query.length < 3) {
	        suggestionsBox.innerHTML = "";
	        suggestionsBox.style.display = "none";
	        return;
	    }

	fetch(`/api/products/search?query=${query}`)
	    .then(response => response.json())
	    .then(displaySuggestions)
	    .catch(console.error);
	});
	
document.addEventListener("click", function (event) {
    if (!searchInput.contains(event.target) && !suggestionsBox.contains(event.target)) {
        suggestionsBox.innerHTML = "";
		suggestionsBox.style.display = "none";
    }
});

function displaySuggestions(suggestions) {
    suggestionsBox.innerHTML = ""; 
    
	if(suggestions.length > 0) {
		suggestions.forEach(suggestion => {
	        const suggestionElement = document.createElement("div");
	        suggestionElement.classList.add("suggestion"); 
			const productName = document.createElement('strong');
			productName.textContent = suggestion.name; 
			const productDescription = document.createElement('p');
			productDescription.textContent = suggestion.description;
			
			suggestionElement.appendChild(productName);
			suggestionElement.appendChild(productDescription);

	        suggestionElement.addEventListener("click", () => {
	            window.location.href = "/products/" + suggestion.id; // redirection vers la page du produit
	        });

	        suggestionsBox.appendChild(suggestionElement); 
	    });
	    suggestionsBox.style.display = "block";
	} else {
		suggestionsBox.style.display = "none"; // On n'affiche pas la boîte si aucun produit correspondant n'est trouvé (sinon boite vide...)
	}
}