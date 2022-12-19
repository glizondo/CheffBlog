<h1 class="page-header">Navigations Edit</h1>

 <div class="form-group col-xs-12 col-md-6">
	 <label for="navigationName">Navigation Name</label>
	 <input type="text" class="form-control" name="navigationName" id="navigationName" autofocus required>
 </div>
 <div class="form-group col-xs-12 col-md-6">
	 <label for="navigationURL">URL</label>
	 <input type="text" class="form-control" name="navURL" id="navigationURL" autofocus required>     
 </div>
 <div class="form-group col-xs-12 col-md-6">
	 <label for="navigationOrder">Order</label>
	 <input type="text" class="form-control" name="navigationOrder" id="navigationOrder" autofocus required>     
</div>
<div class="form-group col-xs-12 col-md-6">
	 <label for="navigationVisible">Visible</label>
	 <select class="form-control" id="navigationVisible" name="navigationVisible">
	 	<option value= "1" selected >Yes</option>
	 	<option value= "0" >No</option>
	 </select>
</div>
<div class="form-group">
	<span>
     	<button class="btn btn-primary"  type="submit" onclick="updateNavigation()" id="navigationAdd" data-toggle="tooltip" title="Save Changes">Save Changes</button>
	</span>

 	<span>
     	<button class = "btn btn-link" type="button" onclick="window.history.back()" data-toggle="tooltip" title="Cancel">Cancel</button>
   	</span>
</div>   