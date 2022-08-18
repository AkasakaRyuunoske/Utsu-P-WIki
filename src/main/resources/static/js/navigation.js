let utsup = document.getElementById("Utsu-P");
let counter = 0;

let PREFIX_LOCAL   = "http://localhost:8080/";
let PREFIX_HEROKU  = "https://.herokuapp.com/";

var currentUser = document.getElementById("currentUser");

function getCookie(cookie_name) {
  let name = cookie_name + "=";
  let decodedCookie = decodeURIComponent(document.cookie);
  let cookies = decodedCookie.split(';');

  for(let i = 0; i <cookies.length; i++) {
    let cookie = cookies[i];
    while (cookie.charAt(0) == ' ') {
      cookie = cookie.substring(1);
    }
    if (cookie.indexOf(name) == 0) {
      return cookie.substring(name.length, cookie.length);
    }
  }
  return "";
}

if (getCookie("userName") != "") {
	currentUser.innerHTML = getCookie("userName").replace("_", " ");
} 

currentUser.onclick = function(){
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

// for some reason after data submition window location changes to /login?
// and not that configured in spring boot (.http.defaultSuccessUrl("/"))
// for now this is solution

// if (window.location.href == PREFIX_LOCAL + "login?") {
// 	window.location.href = PREFIX_LOCAL;
// }