//	header.js is a component responsive for generating headers. 
//	Other than that the main header with progect name is made dynamic.
//	plus shows the current logged user (if not, Annonymus is shown) using userName cookie.
var headers = document.getElementById("headers");

if (headers != null) {
	headers.innerHTML = 
			  "<header class='fav-color hero-container'>" 
			+	"<h1 class='hero glitch layers' data-text='鬱P Wiki' id='Utsu-P'>"
			+		"鬱P Wiki"
			+	"</h1>"
			+ "</header>"
			
			+	"<header class='header-options-text header-grid-container'>"
			+		"<h2 class='header-grid-item' onclick='navigate(this)'>Explore</h2>"
			+		"<h2 class='header-grid-item' onclick='navigate(this)'>Community</h2>"
			+		"<h2 class='header-grid-item' onclick='navigate(this)'>Create</h2>"
			+		"<h2 class='header-grid-item' onclick='navigate(this)'>Buy</h2>"
			+	"</header>";
}

let utsup = document.getElementById("Utsu-P");
let counter = 0;

var currentUser = document.getElementById("currentUser");

//is implemented as counter because in the future there will be more than 2 variations.
// document.getElementById("Utsu-P").onclick = function () {
// 	if (counter == 0) {
// 		utsup.dataset.text = "Utsu-P Wiki";
// 		utsup.innerHTML = "Utsu-P Wiki";
// 		counter = 1;
// 	} else {
// 		utsup.dataset.text = "鬱P Wiki";
// 		utsup.innerHTML = "鬱P Wiki";
// 		counter = 0;
// 	}
// }

document.getElementById("Utsu-P").onclick = function () {
	switch(counter){
		case 0:
		utsup.dataset.text = "鬱P Wiki";
		utsup.innerHTML = "鬱P Wiki";
		counter++;
		break;

		case 1:
		utsup.dataset.text = "Utsu-P Wiki";
		utsup.innerHTML = "Utsu-P Wiki";
		counter++;
		break;

		case 2:
		utsup.dataset.text = "Depression-P Wiki";
		utsup.innerHTML = "Depression-P Wiki";
		counter++;
		break;

		case 3:
		utsup.dataset.text = "My Song Is Shit Wiki";
		utsup.innerHTML = "My Song Is Shit Wiki";
		counter++;
		break;

		case 4:
		utsup.dataset.text = "おはようございます Wiki";
		utsup.innerHTML = "おはようございます Wiki";
		counter++;
		break;

		case 5:
		utsup.dataset.text = "Ohayougozaimasu Wiki";
		utsup.innerHTML = "Ohayougozaimasu Wiki";
		counter++;
		break;

		case 6:
		utsup.dataset.text = "Zsasz Wiki";
		utsup.innerHTML = "Zsasz Wiki";
		counter++;
		break;

		default:
		counter = 0;
	}
}


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