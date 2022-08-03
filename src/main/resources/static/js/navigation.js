let utsup = document.getElementById("Utsu-P");
let counter = 0;

document.getElementById("currentUser").onclick = function(){
	window.location.href = "/logout";
}

document.getElementById("homePage").onclick = function(){
	window.location.href = "/";
}

document.getElementById("authorsPage").onclick = function(){
	window.location.href = "/authors/";
}
	//todo
// document.getElementById("authorPage").onclick = function(){
// 	window.location.href = "/authors/";
// }
document.getElementById("albumsPage").onclick = function(){
	window.location.href = "/albums/";
}
	//todo
// document.getElementById("albumPage").onclick = function(){
// 	window.location.href = "/albums/";
// }



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

document.getElementById("Authors").onclick = function () {
	window.location.href = "/authors/";
}

document.getElementById("Community").onclick = function () {
	window.location.href = "/community/";
}

document.getElementById("Create").onclick = function () {
	window.location.href = "/create/";
}

document.getElementById("Buy").onclick = function () {
	window.location.href = "/buy/";
}