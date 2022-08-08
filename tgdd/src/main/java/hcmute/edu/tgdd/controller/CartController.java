package hcmute.edu.tgdd.controller;

import hcmute.edu.tgdd.model.Cart;
import hcmute.edu.tgdd.model.DataResponse;
import hcmute.edu.tgdd.service.impl.CartServiceImpl;
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
	DataResponse getAllCart() {
		List<Cart> foundListCart = cartService.getAllCart();
		if (foundListCart.size() > 0) {
			return new DataResponse(foundListCart);
		}
		return new DataResponse("400", "No Cart found", 200);
	}

	// find Cart by id
	@GetMapping("/{id}")
	DataResponse findById(@PathVariable Integer id) {
		Optional<Cart> foundCart = cartService.findById(id);
		return foundCart.isPresent() ?
				new DataResponse(foundCart)
				:
				new DataResponse("400", "Cannot find Cart with id = " + id, 200);
	}

	// insert new Cart
	@PostMapping("/insert")
	DataResponse insertCart(@RequestBody Cart newCart) {
		if(Validate.isPhone(newCart.getCustomerPhone())) {
			return new DataResponse(cartService.insertCart(newCart));
		}
		return new DataResponse("400", "Invalid customer phone field", 200);
	}

	// update Cart if found, otherwise insert
	@PutMapping("/{id}")
	DataResponse updateCart(@RequestBody Cart newCart, @PathVariable Integer id) {
		if(Validate.isPhone(newCart.getCustomerPhone())) {
			Cart updatedCart = cartService.updateCart(newCart, id);
			return new DataResponse(updatedCart);
		}
		return new DataResponse("400", "Invalid customer phone field", 200);
	}

	// delete a Cart by id
	@DeleteMapping("/{id}")
	DataResponse deleteCart(@PathVariable Integer id) {
		if (cartService.existsById(id)) {
			cartService.deleteCart(id);
			return new DataResponse("");
		}
		return new DataResponse("400", "Cannot find Cart with id = " + id + " to delete", 200);
	}
}
