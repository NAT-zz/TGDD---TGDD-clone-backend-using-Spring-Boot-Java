package hcmute.edu.tgdd.controller;

import hcmute.edu.tgdd.model.CartDetail;
import hcmute.edu.tgdd.model.DataResponse;
import hcmute.edu.tgdd.service.impl.CartDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/CartDetail")
public class CartDetailController {
	@Autowired
	private CartDetailServiceImpl cartDetailService;

	// get all CartDetail
	@GetMapping("")
	DataResponse getAllCartDetail() {
		List<CartDetail> foundListCartDetail = cartDetailService.getAllCartDetail();
		if (foundListCartDetail.size() > 0) {
			return new DataResponse(foundListCartDetail);
		}
		return new DataResponse("400", "No Cart Detail found", 200);
	}

	// find CartDetail by id
	@GetMapping("/{id}")
	DataResponse findById(@PathVariable Integer id) {
		Optional<CartDetail> foundCartDetail = cartDetailService.findById(id);
		return foundCartDetail.isPresent() ?
				new DataResponse(foundCartDetail)
				:
				new DataResponse("400", "Cannot find Cart Detail with id = " + id, 200);
	}

	// insert new CartDetail
	@PostMapping("/insert")
	DataResponse insertCartDetail(@RequestBody CartDetail newCartDetail) {
		return new DataResponse(cartDetailService.insertCartDetail(newCartDetail));
	}

	// update CartDetail if found, otherwise insert
	@PutMapping("/{id}")
	DataResponse updateCartDetail(@RequestBody CartDetail newCartDetail, @PathVariable Integer id) {
		CartDetail updatedCartDetail = cartDetailService.updateCartDetail(newCartDetail, id);
		return new DataResponse(updatedCartDetail);
	}

	// delete a CartDetail by id
	@DeleteMapping("/{id}")
	DataResponse deleteCartDetail(@PathVariable Integer id) {
		boolean exists = cartDetailService.existsById(id);
		if (exists) {
			cartDetailService.deleteCartDetail(id);
			return new DataResponse("");
		}
		return new DataResponse("400", "Cannot find Cart Detail to delete", 200);
	}

	@GetMapping("/export")
	public void exportToExcel(HttpServletResponse response){
		response.setContentType("application/octet-stream");
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=cart_detail.xlsx";

		response.setHeader(headerKey, headerValue);


	}
}
