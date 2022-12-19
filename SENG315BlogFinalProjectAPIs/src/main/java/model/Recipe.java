package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;

public class Recipe {

	int recipeID;
	String recipeTitle;
	String recipeIngredients;
	String recipeContent;
	String recipeAuthorName;
	Date recipeCreateDate;
	int recipeVisible;
	int categoryID;
	String recipeImage;

	public Recipe() {

	}

	public JSONArray listRecipes() {

		MSSQLConnection mssqlConnection = new MSSQLConnection();

		String sqlString = "SELECT * " + "FROM " + mssqlConnection.getDatabase() + ".dbo.recipes WITH (NOLOCK) ";

		SQLQuery sqlQuery = new SQLQuery();
		sqlQuery.setSqlString(sqlString);

		return sqlQuery.lstQuery();

	}


	public JSONArray listRecipesByCategory() {

		MSSQLConnection mssqlConnection = new MSSQLConnection();

		String sqlString = "SELECT * " + "FROM " + mssqlConnection.getDatabase() + ".dbo.recipes WITH (NOLOCK) "
				+ "WHERE categoryID = " + categoryID;

		SQLQuery sqlQuery = new SQLQuery();
		sqlQuery.setSqlString(sqlString);

		return sqlQuery.lstQuery();

	}

	public String updateRecipe() {

		String message = "Recipe article updated";

		try {

			MSSQLConnection mssqlConnection = new MSSQLConnection();
			Connection connection = mssqlConnection.getConnection();

			String update = "UPDATE " + mssqlConnection.getDatabase() + ".dbo.recipes SET "
					+ "recipeTitle=IsNull(NullIf(?,''),recipeTitle), recipeIngredients=IsNull(NullIf(?,''),recipeIngredients), recipeContent=IsNull(NullIf(?,''),recipeContent),"
					+ "recipeAuthorName=IsNull(NullIf(?,''),recipeAuthorName), recipeVisible=IsNull(?,recipeVisible),recipeImage=IsNull(NullIf(?,''),recipeImage), categoryID=IsNull(?,categoryID) "
					+ "WHERE recipeID=" + recipeID + "";

			PreparedStatement ps = connection.prepareStatement(update);

			ps.setString(1, recipeTitle);
			ps.setString(2, recipeIngredients);
			ps.setString(3, recipeContent);
			ps.setString(4, recipeAuthorName);
			ps.setInt(5, recipeVisible);
			ps.setString(6, recipeImage);
			ps.setInt(7, categoryID);



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

	public JSONObject getRecipe() {

		MSSQLConnection mssqlConnection = new MSSQLConnection();

		String sqlString = "SELECT * " + "FROM " + mssqlConnection.getDatabase() + ".dbo.recipes WITH (NOLOCK) "
				+ "WHERE recipeID = " + recipeID + "";

		SQLQuery sqlQuery = new SQLQuery();
		sqlQuery.setSqlString(sqlString);

		return sqlQuery.getQuery();

	}

	public String addRecipe() {

		String message = "Recipe article added";

		try {

			MSSQLConnection mssqlConnection = new MSSQLConnection();
			Connection connection = mssqlConnection.getConnection();

			String add = "INSERT " + mssqlConnection.getDatabase() + ".dbo.recipes "
					+ "(recipeAuthorName, recipeTitle, recipeIngredients, recipeContent, recipeCreateDate, recipeVisible, categoryID, recipeImage) VALUES (?,?,?,?,?,?,?,?)";

			PreparedStatement ps = connection.prepareStatement(add);

			Date date = new Date();

			ps.setString(1, recipeAuthorName);
			ps.setString(2, recipeTitle);
			ps.setString(3, recipeIngredients);
			ps.setString(4, recipeContent);
			ps.setTimestamp(5, new java.sql.Timestamp(date.getTime()));
			ps.setInt(6, recipeVisible);
			ps.setInt(7, categoryID);
			ps.setString(8, recipeImage);

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
	
	public String deleteRecipe() {

		String message = "Recipe " + recipeID + " Deleted!";

		try {

			MSSQLConnection mssqlConnection = new MSSQLConnection();
			Connection connection = mssqlConnection.getConnection();

			String delete = "DELETE FROM " + mssqlConnection.getDatabase() + ".dbo.recipes " + "WHERE recipeID="
					+ recipeID;

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
	public int getRecipeID() {
		return recipeID;
	}

	public void setRecipeID(int recipeID) {
		this.recipeID = recipeID;
	}

	public String getRecipeTitle() {
		return recipeTitle;
	}

	public void setRecipeTitle(String recipeTitle) {
		this.recipeTitle = recipeTitle;
	}

	public String getRecipeContent() {
		return recipeContent;
	}

	public void setRecipeContent(String recipeContent) {
		this.recipeContent = recipeContent;
	}

	public String getRecipeAuthorName() {
		return recipeAuthorName;
	}

	public void setRecipeAuthorName(String recipeAuthorName) {
		this.recipeAuthorName = recipeAuthorName;
	}

	public Date getRecipeCreateDate() {
		return recipeCreateDate;
	}

	public void setRecipeCreateDate(Date recipeCreateDate) {
		this.recipeCreateDate = recipeCreateDate;
	}

	public int getRecipeVisible() {
		return recipeVisible;
	}

	public void setRecipeVisible(int recipeVisible) {
		this.recipeVisible = recipeVisible;
	}

	public int getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

	public String getRecipeImage() {
		return recipeImage;
	}

	public void setRecipeImage(String recipeImage) {
		this.recipeImage = recipeImage;
	}

	public String getRecipeIngredients() {
		return recipeIngredients;
	}

	public void setRecipeIngredients(String recipeIngredients) {
		this.recipeIngredients = recipeIngredients;
	}

}
