package rest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import service.UserService;

@Path("/users")
public class UsersAPI {

	@GET
	@Produces("application/json")
	@Consumes("application/json")
	public String listUsers() {

		JSONArray users = UserService.listUsers();
		return users.toString();

	}

	@GET
	@Path("/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public String getUser(@PathParam("id") Integer id) {

		JSONObject user = UserService.getUser(id);
		return user.toString();

	}

	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public String addUser(String inputParms) {

		try {
			JSONObject result = UserService.addUser(new JSONObject(inputParms));
			return result.toString();

		} catch (JSONException e) {
			e.printStackTrace();
		}

		return "addUserAPI failed";

	}

	@PUT
	@Produces("application/json")
	@Consumes("application/json")
	public String updateUser(String inputParms) {

		try {
			JSONObject result = UserService.updateUser(new JSONObject(inputParms));
			return result.toString();

		} catch (JSONException e) {
			e.printStackTrace();
			return "updateAPIUser failed";
		}

	}
	
	@POST
	@Path("/authenticate/")
	@Produces("application/json")
	@Consumes("application/json")
	public String authenticate(String inputParms) {

		try {
			JSONObject result = UserService.authenticate(new JSONObject(inputParms));
			return result.toString();

		} catch (JSONException e) {
			e.printStackTrace();
		}

		return "autenticateAPI failed";

	}

}
