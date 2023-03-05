function buy(element){
	element.id = "product";

	let product = document.getElementById('product').childNodes[1].textContent.toLowerCase();

	product = product.replace("utsu-p - ", "");

	window.location.href = "authors/utsu-p/albums/" + product;
}