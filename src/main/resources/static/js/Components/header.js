var headers = document.getElementById("headers");
headers.innerHTML = "<header class='fav-color hero-container'>" 
			+	"<h1 class='hero glitch layers' data-text='鬱P Wiki' id='Utsu-P'>"
			+		"鬱P Wiki"
			+	"</h1>"
			+ "</header>"

			+	"<header class='header-options-text header-grid-container'>"
			+		"<h2 class='header-grid-item' onclick='navigate(this)'>Authors</h2>"
			+		"<h2 class='header-grid-item' onclick='navigate(this)'>Community</h2>"
			+		"<h2 class='header-grid-item' onclick='navigate(this)'>Create</h2>"
			+		"<h2 class='header-grid-item' onclick='navigate(this)'>Buy</h2>"
			+	"</header>";

let utsup = document.getElementById("Utsu-P");
let counter = 0;

var currentUser = document.getElementById("currentUser");


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