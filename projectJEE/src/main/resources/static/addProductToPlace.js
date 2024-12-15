document.addEventListener("DOMContentLoaded", function () {

    // Ajouter un produit
    document.querySelectorAll(".add-product-button").forEach(button => {
        button.addEventListener("click", function () {
            const form = this.closest(".product-form");
            const placeId = form.getAttribute("data-place-id");
            const productId = form.querySelector("#productSelect").value;

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
                console.log("Product added successfully. Reloading page...");
                window.location.reload();
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
            const productId = form.querySelector("#productSelect").value;

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
                console.log("Product removed successfully. Reloading page...");
                window.location.reload();
            })
            .catch(error => {
                console.error("Error details:", error);
                alert("An error occurred while removing the product.");
            });
        });
    });

});
