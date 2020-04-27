
$(document).ready(function() {
	$('#contents').summernote({
		height : 400, // set editor height
		minHeight : 400, // set minimum height of editor
		maxHeight : 400, // set maximum height of editor
		focus : true
	});
});

$(`#btn`).click(function() {
	var title = $(`#title`).val();
	//var contents = $(`#contents`).val();
	var contents = $(`#contents`).summernote('code');

	//console.log(title);
	//console.log($(`#contents`).summernote('code'));

	var ch3 = true;
	$(".files").each(function() {
		// null Check
		if ($(this).val() == "") {
			ch3 = false;
		}
	});

	var ch1 = title != "";
	var ch2 = $(`#contents`).summernote('isEmpty');

	if (ch1 && !ch2 && ch3) {
		$(`#buffer`).val(contents);
		$(`#form`).submit();
	} else {
		alert("제목, 내용을 입력해주세요");
	}
});

const FILE_LIMIT = 5;
var fileNow = 0;
var fileHTML = `<div id=file> <input type="file" class="form-control files" id=file name="files"> <span id="${fileNow}" class="glyphicon glyphicon-remove-sign remove"></span> </div>`;
$('#add').click(function() {
	if (fileNow >= FILE_LIMIT) {
		return;
	}

	$("#fileDiv").append(fileHTML);
	fileNow++;
});

$("#fileDiv").on("click", ".remove", function() {

	$(this).parent().remove();
	fileNow--;
});