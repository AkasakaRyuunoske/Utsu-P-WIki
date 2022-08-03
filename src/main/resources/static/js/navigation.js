let utsup = document.getElementById("Utsu-P");
let counter = 0;

document.getElementById("currentUser").onclick = function(){
	window.location.href = "/logout";
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

function navigate(element) {
	element.id = "location";

	let location = document.getElementById('location').innerHTML.toLowerCase();

	window.location.href = location;
}