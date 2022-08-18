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
	  error : function(e, xhr) {
	  		alert(xhr.getResponseHeader("errorMessage"));
			error.innerHTML = "User Name or Password error";
	  }
	});
}

//.failureHandler((request, response, exception) -> System.out.println(exception))