function fbShare(baseurl, url, title, descr, image, winWidth, winHeight) {
	var winTop = (screen.height / 2) - (winHeight / 2);
	var winLeft = (screen.width / 2) - (winWidth / 2);
	window.open('http://www.facebook.com/sharer.php?s=100&p[title]=' + title
			+ '&p[summary]=' + descr + '&p[url]=' + baseurl + url + '&p[images][0]='
			+ image, 'sharer', 'top=' + winTop + ',left=' + winLeft
			+ ',toolbar=0,status=0,width=' + winWidth + ',height=' + winHeight);
}

function lkShare(baseurl, url) {
	window.open("http://www.linkedin.com/shareArticle?mini=true&url=" + baseurl + url, "Popup", "location,status,scrollbars,resizable,width=800, height=800");
}

function ttShare(baseurl, url) {
	window.open("https://twitter.com/share?url=" + baseurl + url, "Popup", "location,status,scrollbars,resizable,width=800, height=800");
}