function fbShare(url, title, descr, image, winWidth, winHeight) {
	var winTop = (screen.height / 2) - (winHeight / 2);
	var winLeft = (screen.width / 2) - (winWidth / 2);
	window.open('http://www.facebook.com/sharer.php?s=100&p[title]=' + title
			+ '&p[summary]=' + descr + '&p[url]=' + url + '&p[images][0]='
			+ image, 'sharer', 'top=' + winTop + ',left=' + winLeft
			+ ',toolbar=0,status=0,width=' + winWidth + ',height=' + winHeight);
}

function lkShare(url) {
	window.open("http://www.linkedin.com/shareArticle?mini=true&url=" + url, "Popup", "location,status,scrollbars,resizable,width=800, height=800");
}

function gpShare(url) {
	window.open("https://plusone.google.com/_/+1/confirm?hl=en&url=" + url, "Popup", "location,status,scrollbars,resizable,width=800, height=800");
}