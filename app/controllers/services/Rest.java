package controllers.services;

import controllers.account.Authorization;
import play.mvc.Controller;
import play.mvc.Result;


/**
 * Created by plosco on 9/29/16.
 */
public class Rest extends Controller {

	public Result index() {
		// no need to use a *.scala.html file for the response
		return ok("E-commerce");
	}

	public Result login(String user, String password) {
		String response = "";

		Authorization authorization;

		return ok(response);
	}
}
