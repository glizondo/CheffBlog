package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;

public class Comment {

	int commentID;
	int recipeID;
	String commentAuthorName;
	String commentContent;
	Date commentCreateDate;

	public JSONArray listComments() {

		MSSQLConnection mssqlConnection = new MSSQLConnection();

		String sqlString = "SELECT * " + "FROM " + mssqlConnection.getDatabase() + ".dbo.comments WITH (NOLOCK) ";

		SQLQuery sqlQuery = new SQLQuery();
		sqlQuery.setSqlString(sqlString);

		return sqlQuery.lstQuery();

	}

	public JSONArray listCommentsByRecipe() {

		MSSQLConnection mssqlConnection = new MSSQLConnection();

		String sqlString = "SELECT * " + "FROM " + mssqlConnection.getDatabase() + ".dbo.comments WITH (NOLOCK) "
				+ "WHERE recipeID = " + recipeID;

		SQLQuery sqlQuery = new SQLQuery();
		sqlQuery.setSqlString(sqlString);

		return sqlQuery.lstQuery();

	}

	public JSONObject getComment() {

		MSSQLConnection mssqlConnection = new MSSQLConnection();

		String sqlString = "SELECT * " + "FROM " + mssqlConnection.getDatabase() + ".dbo.comments WITH (NOLOCK) "
				+ "WHERE commentID = " + commentID + "";

		SQLQuery sqlQuery = new SQLQuery();
		sqlQuery.setSqlString(sqlString);

		return sqlQuery.getQuery();

	}

	public String addComment() {

		String message = "Comment added into the " + recipeID + " recipe";

		try {

			MSSQLConnection mssqlConnection = new MSSQLConnection();
			Connection connection = mssqlConnection.getConnection();

			String add = "INSERT " + mssqlConnection.getDatabase() + ".dbo.comments "
					+ "(recipeID, commentAuthorName, commentContent, commentCreateDate) VALUES (?,?,?,?)";

			PreparedStatement ps = connection.prepareStatement(add);

			Date date = new Date();

			ps.setInt(1, recipeID);
			ps.setString(2, commentAuthorName);
			ps.setString(3, commentContent);
			ps.setTimestamp(4, new java.sql.Timestamp(date.getTime()));

			ps.executeUpdate();

			try {
				if (ps != null)
					ps.close();
			} catch (Exception e) {
			}
			;
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
			}
			;

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return message;

	}
	
	public String deleteComment() {

		String message = "Comment " + commentID + " Deleted!";

		try {

			MSSQLConnection mssqlConnection = new MSSQLConnection();
			Connection connection = mssqlConnection.getConnection();

			String delete = "DELETE FROM " + mssqlConnection.getDatabase() + ".dbo.comments " + "WHERE commentID="
					+ commentID;

			PreparedStatement ps = connection.prepareStatement(delete);

			ps.executeUpdate();

			try {
				if (ps != null)
					ps.close();
			} catch (Exception e) {
			}
			;
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
			}
			;

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return message;

	}

	// Getters and setters
	public int getCommentID() {
		return commentID;
	}

	public void setCommentID(int commentID) {
		this.commentID = commentID;
	}

	public int getRecipeID() {
		return recipeID;
	}

	public void setRecipeID(int recipeID) {
		this.recipeID = recipeID;
	}

	public String getCommentAuthorName() {
		return commentAuthorName;
	}

	public void setCommentAuthorName(String commentAuthorName) {
		this.commentAuthorName = commentAuthorName;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public Date getCommentCreateDate() {
		return commentCreateDate;
	}

	public void setCommentCreateDate(Date commentCreateDate) {
		this.commentCreateDate = commentCreateDate;
	}

}
