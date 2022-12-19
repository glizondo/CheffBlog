package service;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import model.Category;
import model.Comment;
import model.Navigation;
import model.Recipe;

public class RecipeService {

	public static JSONArray listRecipes() {

		JSONArray recipesArray = new JSONArray();

		Recipe recipe = new Recipe();
		recipesArray = recipe.listRecipes();

		return recipesArray;

	}
	

	public static JSONArray listRecipesByCategory(int categoryID) {

		JSONArray recipesArray = new JSONArray();

		Recipe recipe = new Recipe();
		recipe.setCategoryID(categoryID);
		recipesArray = recipe.listRecipesByCategory();

		return recipesArray;

	}

	public static JSONObject updateRecipe(JSONObject inputParms) {
		String message = "";

		JSONObject result = new JSONObject();

		try {

			int recipeID = inputParms.getInt("recipeID");
			String recipeTitle = inputParms.getString("recipeTitle");
			String recipeIngredients = inputParms.getString("recipeIngredients");
			String recipeContent = inputParms.getString("recipeContent");
			int categoryID = inputParms.getInt("categoryID");
			String recipeImage = inputParms.getString("recipeImage");

			Recipe recipe = new Recipe();
			recipe.setRecipeID(recipeID);
			recipe.setRecipeTitle(recipeTitle);
			recipe.setRecipeIngredients(recipeIngredients);
			recipe.setRecipeContent(recipeContent);
			recipe.setCategoryID(categoryID);
			recipe.setRecipeImage(recipeImage);

			message = recipe.updateRecipe();

			result.put("message", message);
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return result;
	}

	public static JSONObject getRecipe(int id) {

		JSONObject recipeJO = new JSONObject();
		Recipe recipe = new Recipe();
		recipe.setRecipeID(id);

		recipeJO = recipe.getRecipe();

		return recipeJO;
	}

	public static JSONObject addRecipe(JSONObject inputParms) {
		String message = "";

		JSONObject result = new JSONObject();

		try {

			String recipeTitle = inputParms.getString("recipeTitle");
			String recipeIngredients = inputParms.getString("recipeIngredients");
			String recipeContent = inputParms.getString("recipeContent");
			String recipeAuthorName = inputParms.getString("recipeAuthorName");
			int categoryID = inputParms.getInt("categoryID");
			String recipeImage = inputParms.getString("recipeImage");

			Recipe recipe = new Recipe();
			recipe.setRecipeTitle(recipeTitle);
			recipe.setRecipeIngredients(recipeIngredients);
			recipe.setRecipeContent(recipeContent);
			recipe.setRecipeAuthorName(recipeAuthorName);
			recipe.setRecipeVisible(1);
			recipe.setCategoryID(categoryID);
			recipe.setRecipeImage(recipeImage);

			message = recipe.addRecipe();

			result.put("message", message);
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return result;
	}
	
public static JSONObject deleteRecipe(JSONObject inputParms) {
		
		String message = "";

		JSONObject result = new JSONObject();

		try {

			int recipeID = inputParms.getInt("recipeID");
			Recipe recipe = new Recipe();
			recipe.setRecipeID(recipeID);

			message = recipe.deleteRecipe();

			result.put("message", message);
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return result;
	}

}
