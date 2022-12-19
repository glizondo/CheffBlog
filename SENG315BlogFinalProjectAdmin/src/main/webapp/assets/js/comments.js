function listComments() {

	$.ajax({
		url: "../SENG315BlogFinalProjectAPIs/rest/comments/",
		type: 'GET',
		dataType: "json",
		contentType: "application/json",
	}).fail(function(response) {
		console.log(JSON.stringify(response));

	}).done(function(response) {

		$.each(response, function(key, value) {

			if (value.commentContent.length > 150) {
				value.commentContent = value.commentContent.substring(0, 150) + "...";
			}

			var lstResults = 
			"<tr><td><a href = '#' onclick=deleteComModal('" + value.commentID + "','" + encodeURIComponent(value.commentAuthorName) + "') data-toggle='tooltip' title='Delete'><span class='fa fa-trash-alt' aria-hidden='true'></span><span class='sr-only'>Delete</span></a></td>" +
				"<td>" + value.commentID + "</td><td>" + value.recipeID + "</td><td>" + value.commentAuthorName + "</td>" +
				"<td>" + value.commentContent + "</td><td>" + value.commentCreateDate + "</td></tr>";



			if ($("#commentsBody").text()) {
				document.getElementById('commentsBody').innerHTML += lstResults;


			}

		});
	});
}

function deleteComModal(comID, comAuthorName) {

	$("#deleteComModal").modal('show');

	$("#comID").text(comID);
	$("#comAuthorName").text(decodeURIComponent(comAuthorName));


}


function deleteComment() {

	var commentID = $("#comID").text();




	var parms = { commentID: commentID };


	$.ajax({
		url: "./rest/comments/",
		type: 'DELETE',
		dataType: "json",
		contentType: "application/json",
		data: JSON.stringify(parms)
	}).fail(function(response) {
		console.log(JSON.stringify(response));

	}).done(function(response) {

		window.location = "./index.jsp?view=commentslist";
	});
}