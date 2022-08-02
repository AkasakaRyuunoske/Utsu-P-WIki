let utsup = document.getElementById("Utsu-P");
let counter = 0;

document.getElementById("currentUser").onclick = function(){
	windows.location.href = "/logout";
}

document.getElementById("Utsu-P").onclick = function () {

	if (counter == 0) {
		utsup.dataset.text = "Utsu-P Wiki";
		utsup.innerHTML = "Utsu-P Wiki";
		counter = 1;
	} else {
		utsup.dataset.text = "鬱P Wiki";
		utsup.innerHTML = "鬱P Wiki";
		counter = 0;
	}
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