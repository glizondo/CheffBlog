<h1 class="page-header">Recipes List</h1>

<table class="table table-hover">
	<thead id="postBody">
		<tr>
			<th></th>
			<th>Id</th>
			<th>Title</th>
			<th>Category</th>
			<th>Author Name</th>
			<th>Image</th>
			<th>Ingredients</th>
			<th>Content</th>

		</tr>
	</thead>
</table>
<div id="deleteRecModal" class="modal fade" tabindex="-1">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">Confirmation</h5>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
			<div class="modal-body">
				<p class="text-secondary">Are you sure you want to delete this Recipe?</p>
				<label>ID</label>
				<p id='recID' class="text-secondary"></p>
				<label>Name</label>
				<p id='recAuthorName' class="text-secondary"></p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
				<button type="button" class="btn btn-primary" data-dismiss="modal" onclick="deleteRecipe()" >Delete</button>
				
			</div>
		</div>
	</div>
</div>