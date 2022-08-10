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

var form = document.getElementById('myForm');

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
		  success: function(){},
		  dataType: "json",
		  contentType : "application/json"
		});
		

		window.location.href = PREFIX_LOCAL;
	}
}

if (window.location.href == PREFIX_LOCAL + "login?") {

	window.location.href = PREFIX_LOCAL;
}

var caller = document.getElementById('caller');

caller.onclick = function(){
	json = {"Oleg":"Ril oleg","asd":"hyasd"};

	$.ajax({
		type: "POST",
		url:PREFIX_LOCAL + "test-call",
		data: json,
		contentType : "application/json",
		user: "Oleg",
		success : function(data) {
			console.log("SUCCESS: " + data);
		},

		error : function(e) {
			console.log("ERROR: ", e);
		},

		done : function() {
			console.log("DONE");
		}
	});
}