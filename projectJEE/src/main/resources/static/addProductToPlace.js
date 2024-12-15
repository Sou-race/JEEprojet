document.addEventListener("DOMContentLoaded", function () {

    // Ajouter un produit 
    document.querySelectorAll(".add-product-button").forEach(button => {
        button.addEventListener("click", function () {
            const form = this.closest(".product-form");
            const placeId = form.getAttribute("data-place-id");
            const productSelect = form.querySelector("#productSelect");
            const productId = productSelect.value;

            if (!productId) {
                alert("Please select a product.");
                return;
            }

            console.log(`Adding product with ID: ${productId} to place with ID: ${placeId}`);

            fetch(`/${placeId}/add-product`, {
                method: "POST",
                headers: {
                    "Content-Type": "application/x-www-form-urlencoded",
                },
                body: new URLSearchParams({ productId }),
            })
                .then(response => {
                    if (!response.ok) {
                        throw new Error(`Failed to add product. Status: ${response.status}`);
                    }
                    return response.text();
                })
                .then(data => {
                    console.log("Response data:", data);

                    // Récupérer l'élément UL où les produits sont affichés
                    const productList = form.closest("tr").querySelector("ul");

                    // Trouver le produit sélectionné
                    const selectedOption = productSelect.options[productSelect.selectedIndex];
                    const productName = selectedOption.textContent;

                    // Ajouter dynamiquement le produit à la liste
                    const newProduct = document.createElement("li");
                    newProduct.textContent = productName;

                    productList.appendChild(newProduct);

                    console.log(`Product "${productName}" added to the list dynamically.`);
                    alert("Product added successfully!");
                })
                .catch(error => {
                    console.error("Error details:", error);
                    alert("An error occurred while adding the product.");
                });
        });
    });

    // Supprimer un produit 
    document.querySelectorAll(".remove-product-button").forEach(button => {
        button.addEventListener("click", function () {
            const form = this.closest(".product-form");
            const placeId = form.getAttribute("data-place-id");
            const productSelect = form.querySelector("#productSelect");
            const productId = productSelect.value;

            if (!productId) {
                alert("Please select a product.");
                return;
            }

            console.log(`Removing product with ID: ${productId} from place with ID: ${placeId}`);

            fetch(`/${placeId}/remove-product/${productId}`, {
                method: "DELETE",
            })
                .then(response => {
                    if (!response.ok) {
                        throw new Error(`Failed to remove product. Status: ${response.status}`);
                    }
                    return response.text();
                })
                .then(data => {
                    console.log("Response data:", data);

                    // Récupérer l'élément UL où les produits sont affichés
                    const productList = form.closest("tr").querySelector("ul");

                    // Trouver le produit sélectionné
                    const selectedOption = productSelect.options[productSelect.selectedIndex];
                    const productName = selectedOption.textContent;

                    // Supprimer dynamiquement le produit correspondant dans la liste
                    const items = productList.querySelectorAll("li");
                    items.forEach(item => {
                        if (item.textContent.trim() === productName.trim()) {
                            item.remove();
                            console.log(`Product "${productName}" removed dynamically.`);
                        }
                    });

                    alert("Product removed successfully!");
                })
                .catch(error => {
                    console.error("Error details:", error);
                    alert("An error occurred while removing the product.");
                });
        });
    });
});
