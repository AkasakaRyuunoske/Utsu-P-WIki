let location = document.getElementById('location').innerHTML.toLowerCase();
let locationsContainer = document.getElementById('locationsContainer').textContent;

locationsContainer = locationsContainer.replaceAll("\n", "");
locationsContainer = locationsContainer.replaceAll("\t", "");

let locationIndex = locationsContainer.indexOf(location);
