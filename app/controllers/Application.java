package controllers;

import controllers.account.Authorization;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {


    /**
     * Default landing page
     * @return
     */
    public Result index() {
        return ok(index.render("E-commerce"));
    }

    public Result login() {
        // TODO
        Authorization authorization = new Authorization();
        // Check for logged in params
        // bounce to sale if login found?

        // Check for login credentials
        // do auth
            // success - send key
            // failed - give info for failure
        return ok(json.render("JSON"));
    }

    public Result logout() {
        // TODO - do we need this?
        return ok(json.render("JSON"));
    }

    public Result account() {
        /* TODO - get the following based on params:
        Account info
        Order history
        Payment info
        Address info
         */
        return ok(json.render("JSON"));
    }

    public Result sale() {
        // TODO - should have basic info on a campaign sale
        return ok(json.render("JSON"));
    }

    public Result productDetails() {
        // TODO - info specific to a product, size, color, images, etc
        return ok(json.render("JSON"));
    }

    public Result productListing() {
        // TODO - collection of products with limited info. 1 med sized image remove un needed product data
        return ok(json.render("JSON"));
    }

    public Result cart() {
        // TODO - info of products in a users cart. will also strip out some data. 1 small image
        return ok(json.render("JSON"));
    }

    public Result checkout() {
        // TODO - ???
        return ok(json.render("JSON"));
    }



}
