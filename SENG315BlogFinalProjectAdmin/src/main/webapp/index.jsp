<%@include file=".\includes\adminHeader.jsp"%>

<%@include file=".\includes\adminNavigation.jsp"%>

<div class="container-fluid">



	<%
	if (view == null) {
		view = "";
	}

	if (view.equals("recipelist")) {
	%>
	<%@include file=".\includes\recipeList.jsp"%>

	<%
	} else if (view.equals("recipeadd")) {
	%>
	<%@include file=".\includes\recipeAdd.jsp"%>

	<%
	} else if (view.equals("recipeedit")) {
	%>
	<%@include file=".\includes\recipeEdit.jsp"%>

	<%
	} else if (view.equals("navigationlist")) {
	%>
	<%@include file=".\includes\navigationList.jsp"%>

	<%
	} else if (view.equals("navedit")) {
	%>
	<%@include file=".\includes\navigationEdit.jsp"%>

	<%
	} else if (view.equals("categorylist")) {
	%>
	<%@include file=".\includes\categoryList.jsp"%>

	<%
	} else if (view.equals("catedit")) {
	%>
	<%@include file=".\includes\categoryEdit.jsp"%>

	<%
	} else if (view.equals("userlist")) {
	%>
	<%@include file=".\includes\userList.jsp"%>

	<%
	} else if (view.equals("useradd")) {
	%>
	<%@include file=".\includes\userAdd.jsp"%>

	<%
	} else if (view.equals("useredit")) {
	%>
	<%@include file=".\includes\userEdit.jsp"%>

	<%
	} else if (view.equals("commentslist")) {
	%>
	<%@include file=".\includes\commentsList.jsp"%>


	<%
	} else {
	%>
	<%@include file=".\includes\dashboard.jsp"%>
	<%
	}
	%>


</div>
<!-- /.container-fluid -->

<%@include file=".\includes\adminFooter.jsp"%>