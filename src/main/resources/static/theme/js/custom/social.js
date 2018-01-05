function lkShare(url, title) {
	window.open("https://www.linkedin.com/shareArticle?mini=true&url=" + url + "&title=" + title +
			"&summary=.&source=LinkedIn", "Popup", "location,status,scrollbars,resizable,width=800, height=800");
}

function ttShare(url, title) {
	window.open("https://twitter.com/share?url=" + url + "&text=" + title + ":", "Popup", "location,status,scrollbars,resizable,width=800, height=800");
}