/**
 * 
 */

var btn = document.querySelector("#btn");
btn.addEventListener("click", function() {
	// 관련 옵션이 상당히 많으니, w3c lib 보면서 필요한것 찾아서 적용할것
	window.open("./window_pop.html", "",
			"width=500, height=500, top=200, left=200");
});