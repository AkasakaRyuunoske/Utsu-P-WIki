//	login.js is responsive of loging-in the user.
//	takes the data and makes an AJAX(Jquery) Call with all the data
//	but preventing the default behavior of the htmlForm.
//	If credentials are wrong, so AJAX call error case is called
var form  = document.getElementById('logInForm');

var userName;
var password;

var error = document.getElementById('userNameOrPasswordError');

form.onsubmit = function(event){
	// prrevents default form submitting. If not prevented 
	//after submit user will be on ../login? url
	event.preventDefault(); 

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