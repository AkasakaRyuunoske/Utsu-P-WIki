let utsup = document.getElementById("Utsu-P");
let counter = 0;

let PREFIX_LOCAL   = "http://localhost:8080/";
let PREFIX_HEROKU  = "https://.herokuapp.com/";

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

	let location = document.getElementById('location').innerHTML.toLowerCase();
	let locationsContainer = document.getElementById('locationsContainer').innerHTML.toLowerCase();
	let locationIndex = locationsContainer.indexOf(location);
	let sliceTo;

//In this case locationIndex -1 means that the element that was clicked is outside 
//locations container (so it's one of the header-grid-container's element).
//In this case navigate() still works but it slices one letter more than needed.
//Thus this if resolves the problem
	if (locationIndex == -1) {

		sliceTo = locationIndex + (location.length + 1);

	} else {

		sliceTo = locationIndex + location.length;

	}

	location = location.slice(0, sliceTo);

	if (location == "home/") {

		window.location.href = PREFIX_LOCAL;

	} else {

		window.location.href = PREFIX_LOCAL + location;

	}
}

var form  = document.getElementById('myForm');
var token;
var anyerror;
if (form != null) {
	form.onsubmit = function(event){
		userName = document.getElementById('userName').value;
		password = document.getElementById('password').value;

		formData = new FormData(form);
		formData.append("userName", userName);
		formData.append("password", password);

		var json = JSON.stringify(Object.fromEntries(formData));

		$.ajax({
		  type: "POST",
		  url:PREFIX_LOCAL + "login",
		  data: json,
		  contentType : "application/json",

		  success: function(data, textStatus, request){
		  	alert("success произошел");
			token = request.getResponseHeader('Authorization');
			sessionStorage.setItem('JWTToken', token);
		  },
		  error : function(e) {
				alert("ERROR: ", e);
		  },
		  complete: function(status){
		  	alert("Complete: " + status);
		  }

		});
		// window.location.href = PREFIX_LOCAL;
	}
}

// if (window.location.href == PREFIX_LOCAL + "login?") {

// 	window.location.href = PREFIX_LOCAL;
// }

var caller = document.getElementById('caller');

if (caller != null) {
	caller.onclick = function(){
		$.ajax({
			type: "POST",
			url: PREFIX_LOCAL + "test-call",
			contentType: "application/json",
			headers: { 'Authorization': token },
			
			success: function(data, textStatus, request) {
				alert("SUCCESS: " + data);
				console.log("Headers: " + request.getResponseHeader('Authorization'));
				console.log("token in caller is: " + sessionStorage.getItem('JWTToken'));
			},

			error : function(e) {
				alert("ERROR: ", e);
			}
		});
	}
}