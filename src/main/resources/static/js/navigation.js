//	navigation.js is JS extention of navigation.java .
//	is reponsive for showing current user's location helping the navigation.
//	this is realized using locations_container generated from java 
//	and rendered by Thymeleaf making so that every location is clickable
//	and changes user's location to clicked location


let PREFIX_LOCAL   = "http://localhost:8080/";
let PREFIX_HEROKU  = "https://.herokuapp.com/";

var currentUser = document.getElementById("currentUser");

currentUser.onclick = function(){
	window.location.href = "/logout";
}

function navigate(element) {
	element.id 	 	   = "location";

	let location = document.getElementById('location').innerHTML.toLowerCase();
	let locationsContainer = document.getElementById('locationsContainer').innerHTML.toLowerCase();
	let locationIndex = locationsContainer.indexOf(location);
	let sliceTo;

	//In this case locationIndex -1 means that the element that was clicked is outside 
	//locations container (so it's one of the header-grid-container's element).
	//In this case navigate() still works but it slices one letter more than needed.
	//Thus this if resolves the problem.
	if (locationIndex == -1) {

		sliceTo = locationIndex + (location.length + 1);

	} else {

		sliceTo = locationIndex + location.length;

	}

	location = location.slice(0, sliceTo);

	if (location == "home/") {

		window.location.href = PREFIX_LOCAL;

	} else{

		window.location.href = PREFIX_LOCAL + location;
	}
}