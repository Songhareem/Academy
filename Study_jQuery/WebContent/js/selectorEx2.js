/**
 * 
 */

var addLimit = 0;
var index = 0;
var divId = [];
$("#add").click(function() {

	if (addLimit === 5) {
		alert("file은 5개까지");
		return;
	}
	
	var tmpId = `d${index}`;
	divId.push("d" + index);
	$("#fileDiv").append(`<div id=${tmpId}><input type="file"><span class="r" title=${tmpId}>X</span></div>`);
	addLimit++;
	index++;
});

$("#fileDiv").on("click",".r", function() {
	
	console.log($(this));
	var id = $(this).attr("title");
	$(`#${id}`).remove();
	addLimit--;
});