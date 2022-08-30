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
	
	let locationIndex = locationsContainer.indexOf(location);
	let sliceTo;

	alert("location before slice: " + location);

	//In this case locationIndex -1 means that the element that was clicked is outside 
	//locations container (so it's one of the header-grid-container's element).
	//In this case navigate() still works but it slices one letter more than needed.
	if (locationIndex == -1) {

		sliceTo = locationIndex + (location.length + 1);

	} else {

		sliceTo = locationIndex + location.length;

	}


	location = locationsContainer.slice(0, sliceTo);

	console.log("Location with prefix is: " +  PREFIX_LOCAL + location);
	console.log("locationsContainer is: " +  locationsContainer);
	console.log("locationIndex is: " +  locationIndex);
	console.log("sliceTo is: " +  sliceTo);

	if (location == "home/") {

		window.location.href = PREFIX_LOCAL;

	} else{
		location = location.replace("home/", "");
		window.location.href = PREFIX_LOCAL + location;
	}
}