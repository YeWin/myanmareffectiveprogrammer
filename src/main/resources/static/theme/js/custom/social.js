function fbShare(url) {
	window.open("https://www.facebook.com/sharer/sharer.php?u=" + url, "Popup", "location,status,scrollbars,resizable,width=800, height=800");
}

function lkShare(url) {
	window.open("http://www.linkedin.com/shareArticle?mini=true&url=" + url + "&hashtags=mep", "Popup", "location,status,scrollbars,resizable,width=800, height=800");
}

function ttShare(url, text) {
	window.open("https://twitter.com/share?url=" + url + "&text=" + text + ":", "Popup", "location,status,scrollbars,resizable,width=800, height=800");
}