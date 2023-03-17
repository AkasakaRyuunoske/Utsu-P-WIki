function buy(element){
	element.id = "product";

	let product = document.getElementById('product').childNodes[1].textContent.toLowerCase();

	product = product.replace("utsu-p - ", "");

	window.location.href = "authors/utsu-p/albums/" + product;
}

function setTrackList(){
	let trackList = document.getElementsByClassName("contains");

	if (trackList.length > 0) {
		let collectionArr = [].slice.call(trackList);

		for(let i = 0; i < trackList.length ; i++){
		    let result = collectionArr[i].innerHTML.replace(","," ");
		    document.getElementsByClassName("contains")[i].innerHTML = i + " " + result;

		}
	}

}

setTrackList();

function setContains(){
	//document.getElementsByTagName("li")[0].innerText = document.getElelementsByTagName("li")[0].innerText.replaceAll(",","\n");
	let contains = document.getElementsByTagName("li");

	if (contains.length > 0) {
		let collectionArr = [].slice.call(contains);

		for(let i = 0; i < contains.length ; i++){
		    let result = collectionArr[i].innerText.replaceAll(",","\n");
		    document.getElementsByTagName("li")[i].innerText = result;

		}
	}
}

setContains();

