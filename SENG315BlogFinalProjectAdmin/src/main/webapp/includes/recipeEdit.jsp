<h1 class="page-header">Edit Recipe</h1>

<div class="form-group col-xs-12 col-md-6">
        <label for="recipeTitle">Recipe Title</label>
        <input type="text" class="form-control" id="recipeTitle" value="" required autofocus>
</div>
<div class="form-group col-xs-12 col-md-6">
    <label for="categoryID">Category</label>
    <input class="form-control" id="categoryID" required></input>
</div>
<div class="form-group col-xs-12 col-md-6">
	<label for="recipeAuthorName">Author Name</label>
    <input type="text" class="form-control" id="recipeAuthorName" readonly>
</div>
<div class="form-group col-xs-12 col-md-6">
    <label for="recipeImage">Recipe Image</label>
    <input type="text" class="form-control" id="recipeImage" required >
</div>
<div class="form-group col-xs-12 col-md-6">
    <label for="recipeContent">Content</label>
    <input type="text" class="form-control" id="recipeContent" autofocus required>
</div>
<div class="form-group col-xs-12 col-md-6">
    <label for="recipeIngredients">Ingredients</label>
    <input type="text" class="form-control" id="recipeIngredients" autofocus required>
</div>


<div class="form-group col-xs-12">
    <span>
        <button class="btn btn-primary" type="submit" onclick="updateRecipe()" data-toggle="tooltip" title="Save Changes">Save Changes</button>
    </span>
    <span>
        <button class = "btn btn-link" type="button" onclick="window.history.back()" data-toggle="tooltip" title="Cancel">Cancel</button>
    </span>
</div>