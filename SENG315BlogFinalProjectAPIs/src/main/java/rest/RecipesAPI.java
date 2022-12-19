package rest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import service.CommentService;
import service.NavigationService;
import service.RecipeService;

@Path("/recipes")
public class RecipesAPI {

	@GET
	@Produces("application/json")
	@Consumes("application/json")
	public String listRecipes() {

		JSONArray recipesArray = RecipeService.listRecipes();
		return recipesArray.toString();

	}

	@GET
	@Path("/listByCategory/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public String listRecipesByCategory(@PathParam("id") Integer id) {

		JSONArray recipesArray = RecipeService.listRecipesByCategory(id);
		return recipesArray.toString();

	}

	@PUT
	@Produces("application/json")
	@Consumes("application/json")
	public String updateRecipe(String inputParms) {

		try {
			JSONObject result = RecipeService.updateRecipe(new JSONObject(inputParms));
			return result.toString();

		} catch (JSONException e) {
			e.printStackTrace();
			return "updateRecipeAPI failed";
		}

	}

	@GET
	@Path("/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public String getRecipe(@PathParam("id") Integer id) {

		JSONObject result = RecipeService.getRecipe(id);
		return result.toString();

	}

	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public String addRecipe(String inputParms) {

		try {
			JSONObject result = RecipeService.addRecipe(new JSONObject(inputParms));
			return result.toString();

		} catch (JSONException e) {
			e.printStackTrace();
		}

		return "addRecipeAPI failed";

	}

	@DELETE
	@Produces("application/json")
	@Consumes("application/json")
	public String deleteRecipe(String inputParms) {

		try {
			JSONObject result = RecipeService.deleteRecipe(new JSONObject(inputParms));
			return result.toString();

		} catch (JSONException e) {
			e.printStackTrace();
		}

		return "deleteCommentAPI failed";

	}
}
