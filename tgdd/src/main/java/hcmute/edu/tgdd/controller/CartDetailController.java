package hcmute.edu.tgdd.controller;

import hcmute.edu.tgdd.model.CartDetail;
import hcmute.edu.tgdd.model.ResponseObject;
import hcmute.edu.tgdd.service.CartDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/CartDetail")
public class CartDetailController {
	@Autowired
	private CartDetailServiceImpl cartDetailService;

	// get all CartDetail
	@GetMapping("")
	ResponseObject getAllCartDetail() {
		List<CartDetail> foundListCartDetail = cartDetailService.getAllCartDetail();
		if (foundListCartDetail.size() > 0) {
			return new ResponseObject("200 OK", "Get all Cart Detail succesfully", foundListCartDetail);
		}
		return new ResponseObject("404 Not Found", "No Cart Detail found", "");
	}

	// find CartDetail by id
	@GetMapping("/{id}")
	ResponseObject findById(@PathVariable Integer id) {
		Optional<CartDetail> foundCartDetail = cartDetailService.findById(id);
		return foundCartDetail.isPresent() ?
				new ResponseObject("200 OK", "Find Cart Detail by id succesfully", foundCartDetail)
				:
				new ResponseObject("404 Not Found", "Cannot find Cart Detail with id = " + id, "");
	}

	// insert new CartDetail
	@PostMapping("/insert")
	ResponseObject insertCartDetail(@RequestBody CartDetail newCartDetail) {
		return new ResponseObject("200 OK", "Insert Cart Detail successfully", cartDetailService.insertCartDetail(newCartDetail));
	}

	// update CartDetail if found, otherwise insert
	@PutMapping("/{id}")
	ResponseObject updateCartDetail(@RequestBody CartDetail newCartDetail, @PathVariable Integer id) {
		CartDetail updatedCartDetail = cartDetailService.updateCartDetail(newCartDetail, id);
		return new ResponseObject("200 OK", "Update Cart Detail successfully", updatedCartDetail);
	}

	// delete a CartDetail by id
	@DeleteMapping("/{id}")
	ResponseObject deleteCartDetail(@PathVariable Integer id) {
		boolean exists = cartDetailService.existsById(id);
		if (exists) {
			cartDetailService.deleteCartDetail(id);
			return new ResponseObject("200 OK", "Delete CartDetail successfully", "");
		}
		return new ResponseObject("404 Not Found", "Cannot find CartDetail to delete", "");
	}
}
