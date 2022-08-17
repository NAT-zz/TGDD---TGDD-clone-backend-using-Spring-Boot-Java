package hcmute.edu.tgdd.controller;

import hcmute.edu.tgdd.model.CartDetail;
import hcmute.edu.tgdd.model.DataResponse;
import hcmute.edu.tgdd.service.impl.ExportExcelServiceImpl;
import hcmute.edu.tgdd.service.CartDetailService;
import hcmute.edu.tgdd.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/CartDetail")
public class CartDetailController {
	@Autowired
	private CartDetailService cartDetailService;

	@Autowired
	private CartService cartService;

	@Autowired
	private ExportExcelServiceImpl exportExcelService;

	// get all CartDetail
	@GetMapping("")
	DataResponse getAllCartDetail() {
		List<CartDetail> foundListCartDetail = cartDetailService.getAllCartDetail();
		if (foundListCartDetail.size() > 0) {
			return new DataResponse(foundListCartDetail);
		}
		throw new RuntimeException("No Cart Detail found");
	}

	// find CartDetail by id
	@GetMapping("/{id}")
	DataResponse findById(@PathVariable Integer id) {
		Optional<CartDetail> foundCartDetail = cartDetailService.findById(id);
		if(foundCartDetail.isPresent()) {
			return new DataResponse(foundCartDetail);
		}
		throw new RuntimeException("Cannot find Cart Detail with id = " + id);
	}

	@GetMapping("/findByCartId")
	DataResponse findByCartId(@RequestParam Integer id) {
		List<CartDetail> cartDetails = cartDetailService.findByCartId(id);
		if(cartDetails.size() > 0) {
			return new DataResponse(cartDetails);
		}
		throw new RuntimeException("Cannot find Cart Detail with cart id = " + id);
	}

	// insert new CartDetail
	@PostMapping("/insert")
	DataResponse insertCartDetail(@RequestParam String customerPhone, @RequestBody CartDetail newCartDetail) {
		CartDetail cartDetail = cartDetailService.insertCartDetail(customerPhone, newCartDetail);
		return new DataResponse(cartDetail);
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
		throw new RuntimeException("Cannot find Cart Detail to delete");
	}

	@GetMapping("/export")
	public void exportToExcel(HttpServletResponse response) throws Exception {
		response.setContentType("application/octet-stream");
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=cart_detail.xlsx";

		response.setHeader(headerKey, headerValue);

		List<CartDetail> cartDetailList = cartDetailService.getAllCartDetail();

		exportExcelService.export(response, cartDetailList);
	}
}
