/**
 * 
 */

var addLimit = 1;
$("#add").click(function() {

	if (addLimit === 5) {
		alert("file은 5개까지");
		return;
	}
	$("#fileDiv").append(`<br><input type="file">`);
	addLimit++;
});