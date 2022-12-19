<h1 class="page-header">Add Recipe</h1>

<div class="form-group col-xs-12 col-md-6">
    <label for="recipeTitle">Recipe Title</label>
    <input type="text" class="form-control" id="recipeTitle" autofocus required>
</div>

<div class="form-group col-xs-12 col-md-6">
    <label for="categoryID">Category</label>
    <input type="text" class="form-control" id="categoryID" required>
</div>
<div class="form-group col-xs-12 col-md-6">
    <label for="authorName">Author Name</label>
    <input type="text" class="form-control" id="recipeAuthorName" value=	<%=username %> readonly >
</div>
<div class="form-group col-xs-12 col-md-6">
    <label for="recipeImage">Recipe Image</label>
    <input type="text" class="form-control" id="recipeImage" required >
</div>
<div class="form-group col-xs-12 col-md-12">
    <label for="recipeIngredients">Recipe Ingredients</label>
    <input type="text" class="form-control" id="recipeIngredients" autofocus required>
</div>
<div class="form-group col-xs-12 col-md-12">
    <label for="recipeContent">Recipe Content</label>
    <input type="text" class="form-control" id="recipeContent" autofocus required>
</div>

 <div class="form-group">
 <span>
     <button class="btn btn-primary"  type="submit" onclick="addRecipe()" id="recipeAdd" data-toggle="tooltip" title="Add Recipe">Add Recipe</button>
 </span>

 <span>
     <input class = "btn btn-link" type="button" onclick="window.history.back()" value="Cancel" data-toggle="tooltip" title="Cancel">
   </span>
</div>