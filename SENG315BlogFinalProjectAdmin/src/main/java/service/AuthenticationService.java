package service;

import org.json.JSONException;
import org.json.JSONObject;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import model.APICall;

public class AuthenticationService {

	public static String authenticate(JSONObject inputParms, HttpServletRequest request) {

		APICall apiCall = new APICall();
		apiCall.setApiURL("http://localhost:8080/SENG315BlogFinalProjectAPIs/rest/users/authenticate/");
		apiCall.setRequestMethod("POST");
		apiCall.setRequestProperty("application/json");

		String apiResult = apiCall.makeAPICall(inputParms);

		try {

			JSONObject results = new JSONObject(apiResult);
			HttpSession session = request.getSession(true);
			session.setAttribute("loggedIn", null);

			if (results.getString("message").contentEquals("success")) {
				session.setMaxInactiveInterval(-1); // -1 does not expire until page is closed. 43200 = 8 h timeout
													// (12*60*60)
				session.setAttribute("loggedIn", true);
				session.setAttribute("username", inputParms.getString("username"));
				session.setAttribute("userID", results.getString("userID"));
			}

		} catch (JSONException e) {
			e.printStackTrace();
		}

		return apiResult;
	}

}
