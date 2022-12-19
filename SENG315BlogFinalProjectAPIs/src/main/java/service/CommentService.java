package service;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import model.Category;
import model.Comment;

public class CommentService {

	public static JSONArray listComments() {

		JSONArray commentsArray = new JSONArray();

		Comment comment = new Comment();
		commentsArray = comment.listComments();

		return commentsArray;

	}

	public static JSONArray listCommentsByRecipe(int recipeID) {

		JSONArray commentsArray = new JSONArray();

		Comment comment = new Comment();

		comment.setRecipeID(recipeID);
		commentsArray = comment.listCommentsByRecipe();

		return commentsArray;

	}

	public static JSONObject getComment(int id) {

		JSONObject commentJO = new JSONObject();
		Comment comment = new Comment();
		comment.setCommentID(id);

		commentJO = comment.getComment();

		return commentJO;
	}

	public static JSONObject addComment(JSONObject inputParms) {
		String message = "";

		JSONObject result = new JSONObject();

		try {

			int recipeID = inputParms.getInt("recipeID");
			String commentAuthorName = inputParms.getString("commentAuthorName");
			String commentContent = inputParms.getString("commentContent");

			Comment comment = new Comment();
			comment.setRecipeID(recipeID);
			comment.setCommentAuthorName(commentAuthorName);
			comment.setCommentContent(commentContent);

			message = comment.addComment();

			result.put("message", message);
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return result;
	}
	
public static JSONObject deleteComment(JSONObject inputParms) {
		
		String message = "";

		JSONObject result = new JSONObject();

		try {

			int commentID = inputParms.getInt("commentID");
			Comment comment = new Comment();
			comment.setCommentID(commentID);

			message = comment.deleteComment();

			result.put("message", message);
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return result;
	}

}
