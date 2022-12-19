function listUsers() {

	$.ajax({
		url: "../SENG315BlogFinalProjectAPIs/rest/users/",
		type: 'GET',
		dataType: "json",
		contentType: "application/json",
	}).fail(function(response) {
		console.log(JSON.stringify(response));

	}).done(function(response) {

		$.each(response, function(key, value) {


			var lstResults = "<tr><td><a href ='./index.jsp?view=useredit&edit=" + value.userID + "' data-toggle='tooltip' title='View & Edit'><span class='fa fa-pencil-alt fa-fw' aria-hidden='true'></span><span class='sr-only'>View and Edit</span></a></td>" +
				"<td>" + value.userID + "</td><td>" + value.firstName + "</td><td>" + value.lastName + "</td><td>" + value.email + "</td><td>" + value.username + "</td>" +
				"<td>" + value.password + "</td><td>" + value.active + "</td><td>" + value.userImage + "</td></tr>";


			if ($("#userBody").text()) {
				document.getElementById('userBody').innerHTML += lstResults;

			}
		});
	});
}

function addUser() {

	var firstName = $("#firstName").val();
	var lastName = $("#lastName").val();
	var email = $("#email").val();
	var username = $("#username").val();
	var password = $("#password").val();
	var active = $("#active").val();
	var userImage = $("#userImage").val();



	var parms = { firstName: firstName, lastName: lastName, email: email, username: username, password: password, active: active, userImage: userImage };


	$.ajax({
		url: "./rest/users/",
		type: 'POST',
		dataType: "json",
		contentType: "application/json",
		data: JSON.stringify(parms)
	}).fail(function(response) {
		console.log(JSON.stringify(response));

	}).done(function(response) {

		window.location = "./index.jsp?view=userlist";
	});
}



function updateUser() {

	var firstName = $("#firstName").val();
	var lastName = $("#lastName").val();
	var email = $("#email").val();
	var username = $("#username").val();
	var password = $("#password").val();
	var active = $("#active").val();
	var userImage = $("#userImage").val();



	var parms = { userID: userID, firstName: firstName, lastName: lastName, email: email, username: username, password: password, active: active, userImage: userImage };


	$.ajax({
		url: "./rest/users/",
		type: 'PUT',
		dataType: "json",
		contentType: "application/json",
		data: JSON.stringify(parms)
	}).fail(function(response) {
		console.log(JSON.stringify(response));

	}).done(function(response) {
		console.log(JSON.stringify(response));


		window.location = "./index.jsp?view=userlist";
	});
}

function getUser(userID) {

	$.ajax({
		url: "../SENG315BlogFinalProjectAPIs/rest/users/" + userID,
		type: 'GET',
		dataType: "json",
		contentType: "application/json",
	}).fail(function(response) {
		console.log(JSON.stringify(response));

	}).done(function(response) {

		$("#firstName").val(response.firstName);
		$("#lastName").val(response.lastName);
		$("#email").val(response.email);
		$("#username").val(response.username);
		$("#password").val(response.password);
		$("#active").val(response.active);
		$("#userImage").val(response.userImage);



	});
}