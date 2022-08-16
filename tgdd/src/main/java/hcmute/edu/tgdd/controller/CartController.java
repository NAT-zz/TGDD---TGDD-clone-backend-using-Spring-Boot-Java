package hcmute.edu.tgdd.controller;

import hcmute.edu.tgdd.model.Cart;
import hcmute.edu.tgdd.model.DataResponse;
import hcmute.edu.tgdd.service.impl.CartServiceImpl;
import hcmute.edu.tgdd.utils.Validate;
import hcmute.edu.tgdd.utils.Validate.Type;

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
		if(foundCart.isPresent()) {
			return new DataResponse(foundCart);
		}
		throw new RuntimeException("Cannot find Cart with id = " + id);
	}

	@GetMapping("/getCart")
	DataResponse getCart(@RequestParam String customerPhone) {
		if(Validate.isWhatever(Type.PHONE, customerPhone)) {
			List<Cart> foundListCart = cartService.getCart(customerPhone);
			return new DataResponse(foundListCart);
		}
		throw new RuntimeException("Invalid customer phone field");
	}

	@GetMapping("/getOrderHistory")
	DataResponse getOrderHistory(@RequestParam String customerPhone) {
		if(Validate.isWhatever(Type.PHONE, customerPhone)) {
			List<Cart> foundListCart = cartService.getOrderHistory(customerPhone);
			return new DataResponse(foundListCart);
		}
		throw new RuntimeException("Invalid customer phone field");
	}

	// insert new Cart
	@PostMapping("/insert")
	DataResponse insertCart(@RequestBody Cart newCart) {
		if(Validate.isWhatever(Type.PHONE, newCart.getCustomerPhone())) {
			if(cartService.findByCustomerPhoneAndStatusId(newCart.getCustomerPhone(), 1).size() == 0) {
				return new DataResponse(cartService.insertCart(newCart));
			}
		} else {
			throw new RuntimeException("Invalid customer phone field");
		}
		return new DataResponse("Customer cart exist");
	}

	@PutMapping("/order")
	DataResponse order(@RequestParam String customerPhone) {
		if(Validate.isWhatever(Type.PHONE, customerPhone)) {
			Optional<Cart> order = cartService.order(customerPhone);
			return new DataResponse(order);
		}
		throw new RuntimeException("Invalid customer phone field");
	}

	// update Cart if found, otherwise insert
	@PutMapping("/{id}")
	DataResponse updateCart(@RequestBody Cart newCart, @PathVariable Integer id) {
		if(Validate.isWhatever(Type.PHONE ,newCart.getCustomerPhone())) {
			Cart updatedCart = cartService.updateCart(newCart, id);
			return new DataResponse(updatedCart);
		}
		throw new RuntimeException("Invalid customer phone field");
	}

	// delete a Cart by id
	@DeleteMapping("/{id}")
	DataResponse deleteCart(@PathVariable Integer id) {
		if (cartService.existsById(id)) {
			cartService.deleteCart(id);
			return new DataResponse("");
		}
		throw new RuntimeException("Cannot find Cart with id = " + id + " to delete");
	}
}
