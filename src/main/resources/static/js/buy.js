function buy(element){
	element.id = "product";

	let product = document.getElementById('product').childNodes[1].textContent.toLowerCase();

	product = product.replace("utsu-p - ", "");

	window.location.href = "authors/utsu-p/albums/" + product;
}

function setTrackList(){
	let trackList = document.getElementsByClassName("contains");
	let collectionArr = [].slice.call(trackList);

	for(let i = 0; i < trackList.length ; i++){
	    let result = collectionArr[i].innerHTML.replace(","," ");
	    document.getElementsByClassName("contains")[i].innerHTML = i + " " + result;

	}
}

setTrackList();

function setContains(){
	
}

