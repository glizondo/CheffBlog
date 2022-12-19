<%@include file=".\includes\clientHeader.jsp"%>


<!-- Page Content -->
<div class="container">

	<div class="row">

		<%
		if (view == null) {
			view = "";
		}

		if (view.equals("recipelist")) {
		%>
		<%@include file=".\includes\recipeList.jsp"%>
		<%
		} else if (view.equals("recipe")) {
		%>
		<%@include file=".\includes\recipe.jsp"%>
		<%
		
		} else {
		%>
		<%@include file=".\includes\recipeList.jsp"%>
		<%
		}
		%>

		


	</div>
	<!-- /.row -->

</div>
<!-- /.container -->
<%@include file=".\includes\clientFooter.jsp"%>

