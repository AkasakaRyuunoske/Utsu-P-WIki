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
	let locationsContainer = document.getElementById('locationsContainer').textContent;
	
	locationsContainer = locationsContainer.replaceAll("\n", "");
	locationsContainer = locationsContainer.replaceAll("\t", "");
	locationsContainer = locationsContainer.replaceAll(/\s/g, "");
	
	let locationIndex = locationsContainer.indexOf(location);
	let sliceTo;

	//In this case locationIndex -1 means that the element that was clicked is outside 
	//locations container (so it's one of the header-grid-container's element).
	if (locationIndex == -1) {

		window.location.href = PREFIX_LOCAL + location;

	} else {

		sliceTo = locationIndex + location.length;
		location = locationsContainer.slice(0, sliceTo);

		if (location == "home/") {

			window.location.href = PREFIX_LOCAL;

		} else{
			location = location.replace("home/", "");
			window.location.href = PREFIX_LOCAL + location;
		}
	}
}