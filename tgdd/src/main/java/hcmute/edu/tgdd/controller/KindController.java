package hcmute.edu.tgdd.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hcmute.edu.tgdd.model.DataResponse;
import hcmute.edu.tgdd.model.Kind;
import hcmute.edu.tgdd.service.KindService;

@RestController
@RequestMapping(path = "api/kind")
public class KindController {
	@Autowired
	private KindService kindService;
	
	// insert new kind
	@PostMapping("/insert")
	public ResponseEntity<DataResponse> insertKind(@RequestBody Kind newKind){
		try {
			Kind insertedKind = kindService.insertKind(newKind);
			return ResponseEntity.ok().body(
					new DataResponse(insertedKind));
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
					new DataResponse("400", "Something went wrong or kind existed", 400));
					
		}
	}
	
	// get all kind
	@GetMapping("/getAllKind")
	public ResponseEntity<DataResponse> getAll() {
		List<Kind> listAllKind = kindService.getAllKind();
		return listAllKind.isEmpty() ?
				ResponseEntity.status(HttpStatus.NOT_FOUND).body(
						new DataResponse("400", "No kind found", 400)) :
				ResponseEntity.ok().body(
						new DataResponse(listAllKind));		
	}

	// find by id
	@GetMapping("/{id}")
	public ResponseEntity<DataResponse> findById(@PathVariable int id) {
		Optional<Kind> foundKind = kindService.findKindById(id);
		return foundKind.isPresent() ? 
			ResponseEntity.status(HttpStatus.OK).body(new DataResponse(foundKind)) :
			ResponseEntity.status(HttpStatus.NOT_FOUND).body(new DataResponse("404", "Kind not found with id = " + id, 400));
	}

	//update only
	@PutMapping("/{id}")
	public DataResponse updateKind(@RequestBody Kind newKind, @PathVariable int id){
		Kind updateKind = null;
		try
		{
			//updateKind = kindService.updateKindById(newKind, id);
		}catch (Exception e) {
			return new DataResponse("404", "Kind not found or duplicate data", 400);
		}
		return new DataResponse(updateKind);
	}

	//delete
	@DeleteMapping("/{id}")
	public ResponseEntity<DataResponse> deleteKind(@PathVariable int id) {
		if (kindService.kindExistedById(id)) {
			try {
				kindService.deleteKindById(id);
			}
			catch (Exception e) {
				return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
						new DataResponse("500", "Something went wrong", 500));
			}
			return ResponseEntity.ok().body(
					new DataResponse("200 Ok", "Kind deleted", 200));
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
				new DataResponse("400", "Kind not found", 400));
	}
}
