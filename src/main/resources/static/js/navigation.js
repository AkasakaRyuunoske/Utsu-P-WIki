var footer = document.getElementById("footer");
footer.innerHTML = 	
		"<footer class='footer'>"
+		"<div style='padding-left:5%;'>"
+		"	<h2>Created By:"
+		"		<span class='fav-color' style='font-family: 'Old English Text MT'>Akasaka Ryuunosuke</span>"
+		"		<p>GitHub:"
+		"			<a href='https://github.com/AkasakaRyuunoske'>https://github.com/AkasakaRyuunoske</a>"
+		"		</p>"
+		"	</h2>"

+		"	<br>"

+		"	<h2>Special thanks to: 鬱P / Utsu-P</h2>"

+		"	<br>"

+		"	<h3>His Socials:"
+		"		<p>Youtube: "
+		"			<a href='https://www.youtube.com/c/utsupofficial/'>https://www.youtube.com/c/utsupofficial/</a>"
+		"		</p>"

+		"		<p>Official Site:"
+		"			<a href='https://msis.jimdofree.com/'>https://msis.jimdofree.com/</a>"
+		"		</p>"

+		"		<p>Apple Music:"
+		"			<a href='https://music.apple.com/jp/artist/鬱p/383043845'>https://music.apple.com/jp/artist/鬱p/383043845</a>"
+		"		</p> "

+		"		<p>Twitter:"
+		"			<a href='https://twitter.com/asshole_wii'>https://twitter.com/asshole_wii</a>"
+		"		</p>"

+		"		<p>Spotify:"
+		"			<a href='https://open.spotify.com/artist/3Zo5u5IljPxQEfbNY2OgsX?si=KcSszKJqQb6JpRnRiCxKaA&nd=1'>https://open.spotify.com/artist/3Zo5u5IljPxQEfbNY2OgsX?si=KcSszKJqQb6JpRnRiCxKaA&nd=1</a>"
+		"		</p>"

+		"		<p>NicoNico:"
+		"			<a href='https://www.nicovideo.jp/user/176618/mylist/6385075'>https://www.nicovideo.jp/user/176618/mylist/6385075</a>"
+		"		</p> "

+		"		<p>Instagram:"
+		"			<a href='https://www.instagram.com/asshole_wii/'>https://www.instagram.com/asshole_wii/user/176618/mylist/6385075</a>"
+		"		</p>"

+		"		<p>linktr:"
+		"			<a href='https://linktr.ee/asshole_wii'>linktr.ee/asshole_wii</a>"
+		"		</p>"
+		"	</h3>"
+	"	</div>"
+	"</footer>"

let PREFIX_LOCAL   = "http://localhost:8080/";
let PREFIX_HEROKU  = "https://.herokuapp.com/";

var currentUser = document.getElementById("currentUser");

currentUser.onclick = function(){
	window.location.href = "/logout";
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