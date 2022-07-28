package hcmute.edu.tgdd.controller;

import hcmute.edu.tgdd.model.Cart;
import hcmute.edu.tgdd.model.ResponseObject;
import hcmute.edu.tgdd.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping(path = "api/Cart")
public class CartController {
	@Autowired
	private CartRepository repository;

	// get all Cart
	@GetMapping("")
	ResponseObject getAllCart() {
		List<Cart> foundListCart = repository.findAll();
		if (foundListCart.size() > 0) {
			return new ResponseObject("200 OK", "Get all Cart succesfully", foundListCart);
		}
		return new ResponseObject("404 Not Found", "No Cart found", "");
	}

	// find Cart by id
	@GetMapping("/{id}")
	ResponseObject findById(@PathVariable Integer id) {
		Optional<Cart> foundCart = repository.findById(id);
		return foundCart.isPresent() ?
				new ResponseObject("200 OK", "Find Cart by id succesfully", foundCart)
				:
				new ResponseObject("404 Not Found", "Cannot find Cart with id = " + id, "");
	}

	// insert new Cart
	@PostMapping("/insert")
	ResponseObject insertCart(@RequestBody Cart newCart) {
		newCart.setStatusId(0);
		Pattern pattern = Pattern.compile("^\\d{10}$");
		Matcher matcher = pattern.matcher(newCart.getCustomerPhone());
		if(!matcher.matches()) {
			return new ResponseObject("400 Bad Request", "Invalid customer phone field", "");
		}
		return new ResponseObject("200 OK", "Insert Cart successfully", repository.save(newCart));
	}

	// update Cart if found, otherwise insert
	@PutMapping("/{id}")
	ResponseObject updateCart(@RequestBody Cart newCart, @PathVariable Integer id) {
		Pattern pattern = Pattern.compile("^\\d{10}$");
		Matcher matcher = pattern.matcher(newCart.getCustomerPhone());
		if(!matcher.matches()) {
			return new ResponseObject("400 Bad Request", "Invalid customer phone field", "");
		}
		Cart updatedCart = repository.findById(id)
				.map(Cart -> {
					Cart.setCustomerPhone(newCart.getCustomerPhone());
					Cart.setRequest(newCart.getRequest());
					Cart.setCoupon(newCart.getCoupon());
					Cart.setStatusId(newCart.getStatusId());
					return repository.save(Cart);
				}).orElseGet(() -> {
					newCart.setStatusId(0);
					return repository.save(newCart);
				});
		return new ResponseObject("200 OK", "Update Cart successfully", updatedCart);
	}

	// delete a Cart by id
	@DeleteMapping("/{id}")
	ResponseObject deleteCart(@PathVariable Integer id) {
		boolean exists = repository.existsById(id);
		if (exists) {
			repository.deleteById(id);
			return new ResponseObject("200 OK", "Delete Cart successfully", "");
		}
		return new ResponseObject("404 Not Found", "Cannot find Cart to delete", "");
	}
}
