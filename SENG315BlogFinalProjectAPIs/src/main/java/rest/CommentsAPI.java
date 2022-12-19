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
import service.CategoryService;
import service.CommentService;
import service.RecipeService;

@Path("/comments")
public class CommentsAPI {

	@GET
	@Produces("application/json")
	@Consumes("application/json")
	public String listComments() {

		JSONArray commentsArray = CommentService.listComments();
		return commentsArray.toString();

	}

	@GET
	@Path("/listCommentsByRecipe/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public String listCommentsByRecipe(@PathParam("id") Integer id) {

		JSONArray commentsArray = CommentService.listCommentsByRecipe(id);
		return commentsArray.toString();

	}

	@GET
	@Path("/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public String getComment(@PathParam("id") Integer id) {

		JSONObject result = CommentService.getComment(id);
		return result.toString();

	}

	@POST
	@Path("/addComment/")
	@Produces("application/json")
	@Consumes("application/json")
	public String addComment(String inputParms) {

		try {
			JSONObject result = CommentService.addComment(new JSONObject(inputParms));
			return result.toString();

		} catch (JSONException e) {
			e.printStackTrace();
		}

		return "addCommentAPI failed";

	}
	
	@DELETE
	@Produces("application/json")
	@Consumes("application/json")
	public String deleteComment(String inputParms) {

		try {
			JSONObject result = CommentService.deleteComment(new JSONObject(inputParms));
			return result.toString();

		} catch (JSONException e) {
			e.printStackTrace();
		}

		return "deleteCommentAPI failed";

	}

}
