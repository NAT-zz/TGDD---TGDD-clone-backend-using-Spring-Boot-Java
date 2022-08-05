package hcmute.edu.tgdd.controller;

import hcmute.edu.tgdd.model.Cart;
import hcmute.edu.tgdd.model.ResponseObject;
import hcmute.edu.tgdd.service.CartServiceImpl;
import hcmute.edu.tgdd.utils.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/Cart")
public class CartController {
	@Autowired
	private CartServiceImpl cartService;

	// get all Cart
	@GetMapping("")
	ResponseObject getAllCart() {
		List<Cart> foundListCart = cartService.getAllCart();
		if (foundListCart.size() > 0) {
			return new ResponseObject("200 OK", "Get all Cart succesfully", foundListCart);
		}
		return new ResponseObject("404 Not Found", "No Cart found", "");
	}

	// find Cart by id
	@GetMapping("/{id}")
	ResponseObject findById(@PathVariable Integer id) {
		Optional<Cart> foundCart = cartService.findById(id);
		return foundCart.isPresent() ?
				new ResponseObject("200 OK", "Find Cart by id succesfully", foundCart)
				:
				new ResponseObject("404 Not Found", "Cannot find Cart with id = " + id, "");
	}

	// insert new Cart
	@PostMapping("/insert")
	ResponseObject insertCart(@RequestBody Cart newCart) {
		if(Validate.isPhone(newCart.getCustomerPhone())) {
			return new ResponseObject("200 OK", "Insert Cart successfully", cartService.insertCart(newCart));
		}
		return new ResponseObject("400 Bad Request", "Invalid customer phone field", "");
	}

	// update Cart if found, otherwise insert
	@PutMapping("/{id}")
	ResponseObject updateCart(@RequestBody Cart newCart, @PathVariable Integer id) {
		if(Validate.isPhone(newCart.getCustomerPhone())) {
			Cart updatedCart = cartService.updateCart(newCart, id);
			return new ResponseObject("200 OK", "Update Cart successfully", updatedCart);
		}
		return new ResponseObject("400 Bad Request", "Invalid customer phone field", "");
	}

	// delete a Cart by id
	@DeleteMapping("/{id}")
	ResponseObject deleteCart(@PathVariable Integer id) {
		if (cartService.existsById(id)) {
			cartService.deleteCart(id);
			return new ResponseObject("200 OK", "Delete Cart successfully", "");
		}
		return new ResponseObject("404 Not Found", "Cannot find Cart to delete", "");
	}
}
