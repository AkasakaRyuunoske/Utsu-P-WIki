let utsup = document.getElementById("Utsu-P");

console.log(utsup.dataset.text + " <-- that is the value i see");

document.getElementById("Utsu-P").onclick = function () {
	utsup.dataset.text = "Sugoshi tsutzu";
	utsup.innerHTML = "Sugoshi tsutzu";
}

document.getElementById("Authors").onclick = function () {
	window.location.href = "/authors/";
}

document.getElementById("Community").onclick = function () {
	window.location.href = "/community/";
}

document.getElementById("Create").onclick = function () {
	window.location.href = "/create/";
}

document.getElementById("Buy").onclick = function () {
	window.location.href = "/buy/";
}