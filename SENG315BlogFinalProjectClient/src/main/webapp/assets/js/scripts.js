$(document).ready(function() {

	listNavigations();

	view = getQueryStringVariable('view');

	if (view == 'recipe') {
		recipeID = getQueryStringVariable('recipeID');
		getRecipe(recipeID);
		getCommentsByRecipe(recipeID);
	}
	else if (view == 'recipesbycat') {
		categoryID = getQueryStringVariable('categoryID');
		getCategory(categoryID);
		listRecipesByCategory(categoryID);
	}
	else {
		listRecipes();
	}

});


var getQueryStringVariable = function(field, url) {
	var href = url ? url : window.location.href;
	var reg = new RegExp('[?&]' + field + '=([^&#]*)', 'i');
	var string = reg.exec(href);
	return string ? string[1] : null;
};


function listRecipes() {

	$.ajax({
		url: "../SENG315BlogFinalProjectAPIs/rest/recipes/",
		type: 'GET',
		dataType: "json",
		contentType: "application/json",
	}).fail(function(response) {

	}).done(function(response) {

		$.each(response, function(key, value) {

			if (value.recipeContent.length > 200) {
				value.recipeContent = value.recipeContent.substring(0, 200) + "...";
			}

			var blogPosts =
				"<h1 >" + value.recipeTitle + "</h1>" +
				"<img id='imageId_' class='card-img-top' src='./uploads/" + value.recipeImage + "' alt='Card image cap'>" +
				"<div class='card-body'>" +
				"<h2>Ingredients</h2>" +
				"<p class='my-1'>" + value.recipeIngredients + "</p>" +
				"<h2>Steps</h2>" +
				"<p class='card-text'>" + value.recipeContent + "</p>" +
				"<a href='./index.jsp?view=recipe&recipeID=" + value.recipeID + "' class='btn btn-secondary'>Read More &rarr;</a>" +
				"</div>" +
				"<div class='card-footer text-muted'>" +
				" Posted on " + "<a>" + value.recipeCreateDate + "</a>" +
				" by " +
				"<a id='usernameId_" + value.recipeAuthorName + "' href='#'>" + value.recipeAuthorName + "</a>" +
				"</div>" +
				"</div>";


			$("#blogBody").append(blogPosts);

		});
	});
}


function listNavigations() {

	$.ajax({
		url: "../SENG315BlogFinalProjectAPIs/rest/navigations/listvisible/",
		type: 'GET',
		dataType: "json",
		contentType: "application/json",
	}).fail(function(response) {

	}).done(function(response) {

		$.each(response, function(key, value) {


			if (value.hasOwnProperty('categories')) {

				navigations = "<li class='nav-item dropdown'><a class='nav-link dropdown-toggle' href='" + value.navigationURL + "' role='button' data-toggle='dropdown'>" + value.navigationName + "</a>";
				navigations += "<div class='dropdown-menu'>";

				$.each(value.categories, function(k, v) {
					navigations += "<a class='dropdown-item' href='index.jsp?view=recipesbycat&categoryID=" + v.categoryID + "'>" + v.categoryName + "</a>";
				});

				navigations += "</div></li>";

			} else {

				navigations = "<li class='nav-item'><a class='nav-link' href='" + value.navigationURL + "'>" + value.navigationName + "</a></li>";
			}
			$("#navigationUL").append(navigations);

		});
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

		$("#recipeTitle").text(response.recipeTitle);
		$("#recipeIngredients").text(response.recipeIngredients);
		$("#categoryID").text(response.categoryID);
		$("#recipeAuthorName").text(response.recipeAuthorName);
		$("#recipeContent").text(response.recipeContent);
		$("#recipeImage").attr("src", "./uploads/" + response.recipeImage);
		$("#recipeCreateDate").text(response.recipeCreateDate);


	});
}

function getCommentsByRecipe(recipeID) {

	$.ajax({
		url: "../SENG315BlogFinalProjectAPIs/rest/comments/listCommentsByRecipe/" + recipeID,
		type: 'GET',
		dataType: "json",
		contentType: "application/json",
	}).fail(function(response) {
		console.log(JSON.stringify(response));

	}).done(function(response) {

		$.each(response, function(key, value) {

			var comments =
				"<div class='d-flex'>" +
				"<div class='flex-shrink-0'>" +
				"<img class='rounded-circle'src='https://dummyimage.com/50x50/ced4da/6c757d.jpg' />" +
				"</div>" +
				"<div class='ms-3'>" +
				"<div class='fw-bold'>" + value.commentAuthorName + " </div>" +
				"<div class='card-text'>" + value.commentContent + "</div>" +
				"</div>" +
				"</div>";


			$("#comments").append(comments);


		});


	});
}

function addComment() {

	var commentAuthorName = $("#commentAuthorName").val();
	var commentContent = $("#commentContent").val();


	if (commentAuthorName == "") {
		alert("Name cannot be blank");
		$("#commentAuthorName").focus();
		return;
	}

	if (commentContent == "") {
		alert("Content cannot be empty");
		$("#commentContent").focus();
		return;
	}
//		alert("Here");

	var parms = { recipeID: recipeID, commentAuthorName: commentAuthorName, commentContent: commentContent };

	$.ajax({
		url: "../SENG315BlogFinalProjectAPIs/rest/comments/addComment/",
		type: 'POST',
		contentType: "application/json",
		data: JSON.stringify(parms)
	}).fail(function(response) {
		console.log(JSON.stringify(response));

	}).done(function(response) {

//		console.log(JSON.stringify(parms));

		window.location = "./index.jsp?view=recipe";



	});

}






function getCategory(categoryID) {

	$.ajax({
		url: "../SENG315BlogFinalProjectAPIs/rest/categories/" + categoryID,
		type: 'GET',
		dataType: "json",
		contentType: "application/json",
	}).fail(function(response) {
		console.log(JSON.stringify(response));

	}).done(function(response) {


		var heading = "<h1 class='my-4'>" + response.categoryName + "</h1><hr>" +
			"<div class='row'><div><img class='img-responsive img-thumbnail img-rounded artImage' src='./uploads/" + response.categoryImage + "'>" +
			response.categoryContent + "</div></div><hr>";

		$("#articlePageHeading").append(heading);


	});
}


function listRecipesByCategory(categoryID) {

	$.ajax({
		url: "../SENG315BlogFinalProjectAPIs/rest/recipes/listByCategory/" + categoryID,
		type: 'GET',
		dataType: "json",
		contentType: "application/json",
	}).fail(function(response) {

	}).done(function(response) {

		$.each(response, function(key, value) {

			if (value.recipeContent.length > 200) {
				value.recipeContent = value.recipeContent.substring(0, 200) + "...";
			}


			var blogPosts = "<div class='card mb-4'>" +
				"<img id='imageId_" + value.recipeAuthorName + "' class='card-img-top' src='./uploads/" + value.recipeImage + "' alt='Card image cap'>" +
				"<div class='card-body'>" +
				"<h2 class='card-title'>" + value.recipeTitle + "</h2>" +
				"<p class='card-text'>" + value.recipeContent + "</p>" +
				"<a href='./index.jsp?view=recipe&recipeID=" + value.recipeID + "' class='btn btn-danger'>Read More &rarr;</a>" +
				"</div>" +
				"<div class='card-footer text-muted'>" +
				" Posted on " + "<a>" + value.recipeCreateDate + "</a>" +
				" by " +
				"<a id='usernameId_" + value.recipeAuthorName + "' href='#'>" + value.recipeAuthorName + "</a>" +
				"</div>" +
				"</div>";

			$("#blogBody").append(blogPosts);

		});
	});
}
