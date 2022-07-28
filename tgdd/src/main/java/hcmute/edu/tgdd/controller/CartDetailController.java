package hcmute.edu.tgdd.controller;

import hcmute.edu.tgdd.model.CartDetail;
import hcmute.edu.tgdd.model.ResponseObject;
import hcmute.edu.tgdd.repository.CartDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/CartDetail")
public class CartDetailController {
	@Autowired
	private CartDetailRepository repository;

	// get all CartDetail
	@GetMapping("")
	ResponseObject getAllCartDetail() {
		List<CartDetail> foundListCartDetail = repository.findAll();
		if (foundListCartDetail.size() > 0) {
			return new ResponseObject("200 OK", "Get all Cart Detail succesfully", foundListCartDetail);
		}
		return new ResponseObject("404 Not Found", "No Cart Detail found", "");
	}

	// find CartDetail by id
	@GetMapping("/{id}")
	ResponseObject findById(@PathVariable Integer id) {
		Optional<CartDetail> foundCartDetail = repository.findById(id);
		return foundCartDetail.isPresent() ?
				new ResponseObject("200 OK", "Find CartDetail by id succesfully", foundCartDetail)
				:
				new ResponseObject("404 Not Found", "Cannot find CartDetail with id = " + id, "");
	}

	// insert new CartDetail
	@PostMapping("/insert")
	ResponseObject insertCartDetail(@RequestBody CartDetail newCartDetail) {
		return new ResponseObject("200 OK", "Insert CartDetail successfully", repository.save(newCartDetail));
	}

	// update CartDetail if found, otherwise insert
	@PutMapping("/{id}")
	ResponseObject updateCartDetail(@RequestBody CartDetail newCartDetail, @PathVariable Integer id) {
		CartDetail updatedCartDetail = repository.findById(id)
				.map(CartDetail -> {
					CartDetail.setProductId(newCartDetail.getProductId());
					CartDetail.setQuantity(newCartDetail.getQuantity());
					CartDetail.setCartId(newCartDetail.getCartId());
					return repository.save(CartDetail);
				}).orElseGet(() -> {
					newCartDetail.setId(id);
					return repository.save(newCartDetail);
				});
		return new ResponseObject("200 OK", "Update CartDetail successfully", updatedCartDetail);
	}

	// delete a CartDetail by id
	@DeleteMapping("/{id}")
	ResponseObject deleteCartDetail(@PathVariable Integer id) {
		boolean exists = repository.existsById(id);
		if (exists) {
			repository.deleteById(id);
			return new ResponseObject("200 OK", "Delete CartDetail successfully", "");
		}
		return new ResponseObject("404 Not Found", "Cannot find CartDetail to delete", "");
	}
}
