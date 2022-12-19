function listRecipes() {

	$.ajax({
		url: "../SENG315BlogFinalProjectAPIs/rest/recipes/",
		type: 'GET',
		dataType: "json",
		contentType: "application/json",
	}).fail(function(response) {
		console.log(JSON.stringify(response));

	}).done(function(response) {

		$.each(response, function(key, value) {

			if (value.recipeContent.length > 150) {
				value.recipeContent = value.recipeContent.substring(0, 150) + "...";
			}

			var lstResults = "<tr><td><a href ='./index.jsp?view=recipeedit&edit=" + value.recipeID + "' data-toggle='tooltip' title='View & Edit'><span class='fa fa-pencil-alt fa-fw' aria-hidden='true'></span><span class='sr-only'>View and Edit</span></a>" +
			"<a href = '#' onclick=deleteRecModal('" + value.recipeID + "','" + encodeURIComponent(value.recipeAuthorName) + "') data-toggle='tooltip' title='Delete'><span class='fa fa-trash-alt' aria-hidden='true'></span><span class='sr-only'>Delete</span></a></td>" +
				"<td>" + value.recipeID + "</td><td>" + value.recipeTitle + "</td><td>" + value.categoryID + "</td>" +
				"<td>" + value.recipeAuthorName + "</td><td>" + value.recipeImage + "</td><td>" + value.recipeIngredients + "</td><td>" + value.recipeContent + "</td></tr>";


			if ($("#postBody").text()) {
				document.getElementById('postBody').innerHTML += lstResults;

			}
		});
	});
}

function addRecipe() {

	var recipeTitle = $("#recipeTitle").val();
	var categoryID = $("#categoryID").val();
	var recipeIngredients = $("#recipeIngredients").val();
	var recipeContent = $("#recipeContent").val();
	var recipeAuthorName = $("#recipeAuthorName").val();
	var recipeImage = $("#recipeImage").val();




	var parms = { recipeTitle: recipeTitle, categoryID: categoryID, recipeIngredients: recipeIngredients, recipeContent: recipeContent, recipeAuthorName: recipeAuthorName, recipeImage: recipeImage }


	$.ajax({
		url: "./rest/recipes/",
		type: 'POST',
		dataType: "json",
		contentType: "application/json",
		data: JSON.stringify(parms)
	}).fail(function(response) {
		console.log(JSON.stringify(response));

	}).done(function(response) {

		window.location = "./index.jsp?view=recipelist";


	});
}



function updateRecipe() {

	var recipeTitle = $("#recipeTitle").val();
	var categoryID = $("#categoryID").val();
	var recipeAuthorName = $("#recipeAuthorName").val();
	var recipeImage = $("#recipeImage").val();
	var recipeIngredients = $("#recipeIngredients").val();
	var recipeContent = $("#recipeContent").val();




	var parms = { recipeID: recipeID, recipeTitle: recipeTitle, categoryID: categoryID, recipeAuthorName: recipeAuthorName, recipeImage: recipeImage, recipeIngredients: recipeIngredients, recipeContent: recipeContent }


	$.ajax({
		url: "./rest/recipes/",
		type: 'PUT',
		dataType: "json",
		contentType: "application/json",
		data: JSON.stringify(parms)
	}).fail(function(response) {
		console.log(JSON.stringify(response));

	}).done(function(response) {

		window.location = "./index.jsp?view=recipelist";
	});
}

function getRecipe(recipeID) {

	$.ajax({
		url: "../SENG315BlogFinalProjectAPIs/rest/recipes/" + recipeID,
		type: 'GET',
		dataType: "json",
		contentType: "application/json",
	}).fail(function(response) {
		console.log(JSON.stringify(response));

	}).done(function(response) {

		$("#recipeTitle").val(response.recipeTitle);
		$("#categoryID").val(response.categoryID);
		$("#recipeAuthorName").val(response.recipeAuthorName);
		$("#recipeContent").val(response.recipeContent);
		$("#recipeImage").val(response.recipeImage);
		$("#recipeIngredients").val(response.recipeIngredients);


	});
}

function deleteRecModal(recID, recAuthorName) {

	$("#deleteRecModal").modal('show');

	$("#recID").text(recID);
	$("#recAuthorName").text(decodeURIComponent(recAuthorName));

}

function deleteRecipe() {

	var recipeID = $("#recID").text();




	var parms = { recipeID: recipeID };


	$.ajax({
		url: "./rest/recipes/",
		type: 'DELETE',
		dataType: "json",
		contentType: "application/json",
		data: JSON.stringify(parms)
	}).fail(function(response) {
		console.log(JSON.stringify(response));

	}).done(function(response) {

		window.location = "./index.jsp?view=recipelist";
	});
}