package controllers.services;

import play.mvc.*;

/**
 * Created by plosco on 9/29/16.
 */
public class Rest extends Controller {

	public Result index() {
		return ok(index.render("E-commerce"));
	}
}
