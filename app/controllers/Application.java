package controllers;

import controllers.account.Authorization;
import play.mvc.*;

import views.html.*;

/**
 * Used to test entire service. This connects to a front end design
 */

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
        return ok(login.render("login"));
    }

    public Result logout() {
        // TODO - re route to login after cleaning up some things
        return redirect("/login");
    }

    public Result account() {
        /* TODO - get the following based on params:
        Account info
        Order history
        Payment info
        Address info
         */
        return ok(account.render("login"));
    }

    public Result sale() {
        // TODO - should have basic info on a campaign sale
        return ok(sale.render("sale"));
    }

    public Result productDetails() {
        // TODO - info specific to a product, size, color, images, etc
        return ok(productDetails.render("JSON"));
    }

    public Result productListing() {
        // TODO - collection of products with limited info. 1 med sized image remove un needed product data
        return ok(productListing.render("JSON"));
    }

    public Result cart() {
        // TODO - info of products in a users cart. will also strip out some data. 1 small image
        return ok(cart.render("JSON"));
    }

    public Result checkout() {
        // TODO - ???
        return ok(checkout.render("JSON"));
    }



}
