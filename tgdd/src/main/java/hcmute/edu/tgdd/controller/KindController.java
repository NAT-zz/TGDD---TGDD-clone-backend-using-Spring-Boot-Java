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

import hcmute.edu.tgdd.model.Kind;
import hcmute.edu.tgdd.model.ResponseObject;
import hcmute.edu.tgdd.service.KindService;

@RestController
@RequestMapping(path = "api/kind")
public class KindController {
	@Autowired
	private KindService kindService;
	
	// insert new kind
	@PostMapping("/insertKind")
	public ResponseEntity<ResponseObject> insertKind(@RequestBody Kind newKind){
		try {
			Kind insertedKind = kindService.insertKind(newKind);
			return ResponseEntity.ok().body(
					new ResponseObject("200 Ok", "New kind added", insertedKind));
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
					new ResponseObject("501 Not Implemented", "Something went wrong or kind existed", ""));
					
		}
	}
	
	// get all kind
	@GetMapping("/getAllKind")
	public ResponseEntity<ResponseObject> getAll() {
		List<Kind> listAllKind = kindService.getAllKind();
		return listAllKind.isEmpty() ?
				ResponseEntity.status(HttpStatus.NOT_FOUND).body(
						new ResponseObject("404 Not Found", "No kind found", "")) :
				ResponseEntity.ok().body(
						new ResponseObject("200 Ok", "Success", listAllKind));		
	}
	// find by id
	@GetMapping("/{id}")
	public ResponseEntity<ResponseObject> findById(@PathVariable int id) {
		Optional<Kind> foundKind = kindService.findKindById(id);
		return foundKind.isPresent() ? 
			ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("200 Ok", "Kind found", foundKind)) :
			ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObject("404 Not Found", "Kind not found with id = " + id, ""));
	}
	//update only
	@PutMapping("/{id}")
	public ResponseObject updateKind(@RequestBody Kind newKind, @PathVariable int id){
		Kind updateKind = null;
		try
		{
			updateKind = kindService.updateKindById(newKind, id);
		}catch (Exception e) {
			return new ResponseObject("404 Not Found", "Kind not found or duplicate data", "");
		}
		return new ResponseObject("200 Ok", "Kind updated", updateKind);
	}
	//delete
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseObject> deleteKind(@PathVariable int id) {
		if (kindService.kindExistedById(id)) {
			try {
				kindService.deleteKindById(id);
			}
			catch (Exception e) {
				return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
						new ResponseObject("501 Not Implemented", "Something went wrong", ""));
			}
			return ResponseEntity.ok().body(
					new ResponseObject("200 Ok", "Kind deleted", ""));
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
				new ResponseObject("404 Not Found", "Kind not found", ""));
	}
}
