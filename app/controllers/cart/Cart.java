package controllers.cart;

import models.Product;
import models.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by plosco on 9/20/16.
 */
public class Cart {

	private User user;
	private List<Product> products;

	public Cart(User user) {
		this.user = user;
		this.products = new ArrayList<>();
	}

	public User getUser() {
		return user;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void addProduct(Product product) {
		this.products.add(product);
	}

	public void removeProduce(Product product) {
		this.products.remove(product);
	}
}
