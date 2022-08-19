var form  = document.getElementById('myForm');

var userName;
var password;

var error = document.getElementById('userNameOrPasswordError');

form.onsubmit = function(event){
	event.preventDefault(); // prrevents default form submitting.

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
		window.location.href = "/";
	  },

	  //In order to be able to read response header
	  //function must follow this temoplate.
	  //the function must be absolutly same as below 
	  //otherwise it DOES NOT WORK.
	  error : function(request, textStatus, errorThrown) {
			error.innerHTML = request.getResponseHeader('errorMessage');
	  }
	});
}

//.failureHandler((request, response, exception) -> System.out.println(exception))