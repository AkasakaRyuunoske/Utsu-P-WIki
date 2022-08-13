let utsup = document.getElementById("Utsu-P");
let counter = 0;

let PREFIX_LOCAL   = "http://localhost:8080/";
let PREFIX_HEROKU  = "https://.herokuapp.com/";

var currentUser = document.getElementById("currentUser");
var form  = document.getElementById('myForm');

var token;
var userName;
var password;

if (sessionStorage.getItem('userName')) {
	currentUser.innerHTML = sessionStorage.getItem('userName');
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
//Thus this if resolves the problem
	if (locationIndex == -1) {

		sliceTo = locationIndex + (location.length + 1);

	} else {

		sliceTo = locationIndex + location.length;

	}

	location = location.slice(0, sliceTo);

	if (location == "home/") {
		if (sessionStorage.getItem('JWTToken')) {
		$.ajax({
			type: "GET",
			url: PREFIX_LOCAL,
			async: false,
			contentType: "application/json",
			headers: { 'Authorization': sessionStorage.getItem('JWTToken')},
			
			success: function() {},

			error : function(e) {
				console.log("ERROR: ", e);
			}
		});

		window.location.href = PREFIX_LOCAL;
		}
	}

	if (location != "home/") {
		if (sessionStorage.getItem('JWTToken')) {
			$.ajax({
				type: "GET",
				url: PREFIX_LOCAL + location,
				async: false,
				contentType: "application/json",
				headers: { 'Authorization': sessionStorage.getItem('JWTToken')},
				
				success: function(data, textStatus, request) {
					alert("was called");
					alert("token in locations is: " + sessionStorage.getItem('JWTToken'));
					alert("username in locations is: " + sessionStorage.getItem('userName'));
				},

				error : function(e) {
					console.log("ERROR: ", e);
				}
			});
		window.location.href = PREFIX_LOCAL + location;
		}
	}
}
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
		  async: false,
		  data: json,
		  contentType : "application/json",

		  success: function(data, textStatus, request){
		  	alert("success");

		  	if (sessionStorage.getItem('JWTToken')) {
		  		sessionStorage.removeItem('JWTToken');
		  	}

			token = request.getResponseHeader('Authorization');

			sessionStorage.setItem('JWTToken', token);
			sessionStorage.setItem('userName', userName);
		  },
		  error : function(e) {
				alert("ERROR: ", e);
		  },
		  complete: function () {
		  	alert("comelete");
		  }
		});
		window.location.href = PREFIX_LOCAL;
	}
}

if (window.location.href == PREFIX_LOCAL + "login?") {
	window.location.href = PREFIX_LOCAL;
}

var caller = document.getElementById('caller');

if (caller != null) {
	caller.onclick = function(){
		$.ajax({
			type: "POST",
			url: PREFIX_LOCAL + "test-call",
			async: false,
			contentType: "application/json",
			headers: { 'Authorization': sessionStorage.getItem('JWTToken'), 'user':'Oleg'},
			
			success: function(data, textStatus, request) {
				alert("Headers: " + request.getResponseHeader('Authorization'));

				console.log("token in caller is: " + sessionStorage.getItem('JWTToken'));
				console.log("username in caller is: " + sessionStorage.getItem('userName'));
				window.location.href = PREFIX_LOCAL;
			},

			error : function(e) {
				console.log("ERROR: ", e);
			}
		});
	}
}