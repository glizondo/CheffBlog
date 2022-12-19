<h1 class="page-header">Comments List</h1>



<table class="table table-hover">
	<thead id="commentsBody">
		<tr>
			<th></th>
			<th>Id</th>
			<th>Recipe Id</th>
			<th>Author Name</th>
			<th>Content</th>
			<th>Created Date</th>

		</tr>
	</thead>
</table>


<div id="deleteComModal" class="modal fade" tabindex="-1">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">Confirmation</h5>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
			<div class="modal-body">
				<p class="text-secondary">Are you sure you want to delete this Comment?</p>
				<label>ID</label>
				<p id='comID' class="text-secondary"></p>
				<label>Name</label>
				<p id='comAuthorName' class="text-secondary"></p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
				<button type="button" class="btn btn-primary" data-dismiss="modal" onclick="deleteComment()" >Delete</button>
				
			</div>
		</div>
	</div>
</div>
