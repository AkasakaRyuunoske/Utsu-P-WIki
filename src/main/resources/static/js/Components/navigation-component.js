let locationsContainer = document.getElementById('locationsContainer').textContent;
let currentPosition;

if (locationsContainer != null) {

	locationsContainer = locationsContainer.replaceAll("\n", "");
	locationsContainer = locationsContainer.replaceAll("\t", "");

	currentPosition = locationsContainer.split("/");

	// https://stackoverflow.com/questions/3216013/get-the-last-item-in-an-array
	// According to the top upvoted answer ES-2022 allows you to do shit below
	// --->  currentPosition = currentPosition.at(-1);
	// But we not gonna do this, instead:
	currentPosition = currentPosition[currentPosition.length-1]
} else {
	console.log("Something went wrong.");
}

subHeader = document.getElementById("sub-header");

if (subHeader != null) {
	subHeader.innerHTML = currentPosition;
} else {
	console.log("Something went wrong.");
}