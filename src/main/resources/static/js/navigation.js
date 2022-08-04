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
	element.id 	 	   = "location";

	let PREFIX_LOCAL   = "http://localhost:8080/";
	let PREFIX_HEROKU  = "https://.herokuapp.com/";

	let location = document.getElementById('location').innerHTML.toLowerCase();
	let locationsContainer = document.getElementById('locationsContainer').innerHTML.toLowerCase();
	let locationIndex = locationsContainer.indexOf(location);
	let sliceTo;
	if (locationIndex == -1) {
		sliceTo = locationIndex + (location.length + 1);
	} else {
		sliceTo = locationIndex + location.length;
	}

	console.log(location + " starting location is that");
	console.log(locationsContainer + " locationsContainer is that");
	console.log(locationIndex + " locationIndex is that");
	console.log(sliceTo + " sliceTo is that");

	location = location.slice(0, sliceTo);

	console.log(location + " location after optimisation");
	if (location == "home/") {

		window.location.href = PREFIX_LOCAL;

	} else {

		window.location.href = PREFIX_LOCAL + location;

	}
}

// let toSearch = "/utsu-p";
// let text = "/authors/utsu-p/albums/Warufuzake";
// let result = text.indexOf(toSearch);
// let howToSlice = result + toSearch.length;
// let finalString = text.slice(0,15)
// document.getElementById("demo").innerHTML = finalString; 