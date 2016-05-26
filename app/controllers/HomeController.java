package controllers;

import models.Product;
import play.data.FormFactory;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.List;

import static play.libs.Json.toJson;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */

    private final FormFactory formFactory;
    private final JPAApi jpaApi;

    @Inject
    public HomeController(FormFactory formFactory, JPAApi jpaApi) {
        this.formFactory = formFactory;
        this.jpaApi = jpaApi;
    }

    public Result index() {
//        return ok(index.render("Your new application is ready."));
        return ok("Your new application is ready.");
    }

    @Transactional
    public Result addProduct() {
        Product product = formFactory.form(Product.class).bindFromRequest().get();
        jpaApi.em().persist(product);
//        return redirect(routes.HomeController.getProducts());
        return ok("Saved");
    }

    @Transactional(readOnly = true)
    public Result getProducts() {
        List<Product> products = jpaApi.em().createQuery("select p from Product p").getResultList();
        return ok(toJson(products));
    }

}
