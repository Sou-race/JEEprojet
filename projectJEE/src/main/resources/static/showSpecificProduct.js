function addParamIdProduct(productId) {
	const url = new URL(window.location.href); 	
	url.searchParams.set('idProduct', productId);
	window.location.href = url.toString();
}
function removeParamIdProduct() {
	const url = new URL(window.location.href);
	url.searchParams.delete('idProduct');
	window.location.href = url.toString();
}