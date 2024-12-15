document.addEventListener("DOMContentLoaded", function () {
      
        document.querySelector(".delete-product-btn").addEventListener("click", function () {
            const productId = this.getAttribute("data-product-id");

          
            if (confirm("Are you sure you want to delete this product?")) {
                
                fetch(`/products/${productId}`, {
                    method: "DELETE",
                })
                    .then(response => {
                        if (!response.ok) {
                            throw new Error(`Failed to delete product. Status: ${response.status}`);
                        }
                        return response.text();
                    })
                    .then(data => {
                        alert("Product deleted successfully!");

                      
                        const modal = document.querySelector(".productModal");
                        if (modal) {
                            modal.style.display = "none"; 
                        }

                    
                    })
                    .catch(error => {
                        console.error("Error details:", error);
                        alert("An error occurred while deleting the product.");
                    });
            }
        });
    });