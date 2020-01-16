var btnList = document.getElementById("btnList");

btnList.addEventListener("click", function(e) {
	location.href = "/board/list";
});

var btnupdate = document.getElementById("btnupdate");
var submitupdate = document.getElementById("submitupdate");

var boardtitle = document.getElementById("boardtitle");
var boardcontent = document.getElementById("boardcontent");

btnupdate.addEventListener("click", function(e) {
	btnupdate.style.visibility = "hidden";
	submitupdate.style.visibility = "visible";
	$("#boardtitle").attr("readonly", false);
	$("#boardcontent").attr("readonly", false);

});

