
<section class="mb-5">



	<div>

		<div>
		
		<br>

			<h1  style="text-transform:uppercase"  style="font-family:Bahnschrift" id="recipeTitle"></h1>


			 <img src=./uploads/images/line.png class="img-fluid rounded" src=""
				alt="">
			 <img id="recipeImage" class="img-fluid center" src=""
				alt="">
			<hr>

			Ingredients
			<p id="recipeIngredients" class="lead"></p>
			Steps
			<p id="recipeContent" class="lead"></p>
			<hr>

			<p style="font-family:Bahnschrift" class="lead">
				by <a id="recipeAuthorName" ></a> on <a id="recipeCreateDate"></a>
			</p>

			<p id="recipeCreateDate"></p>

		</div>
		<!-- Comment form-->
		<form class="mb-4">
			<input type="text" placeholder="Type your name" class="form-control"
				id="commentAuthorName" required>
			<textarea id="commentContent" class="form-control" rows="3"
				placeholder="Leave a comment!" required></textarea>
			<span>
				<button class="btn btn-primary" type="submit" onclick="addComment()"
					id="commentAdd" data-toggle="tooltip" title="Add Comment">Add
					Comment</button>
			</span>
		</form>

		<!-- Single comment-->
		<div id="comments"></div>
	</div>
</section>