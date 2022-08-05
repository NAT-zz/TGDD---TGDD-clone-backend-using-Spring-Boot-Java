package hcmute.edu.tgdd.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hcmute.edu.tgdd.model.Admin;
import hcmute.edu.tgdd.model.ResponseObject;
import hcmute.edu.tgdd.service.AdminService;

@RestController
@RequestMapping(path = "api/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	// no insert for admin
	// get all admin 
	@GetMapping("/getAllAdmin")
	public ResponseEntity<ResponseObject> getAll(){
		List<Admin> listAllAdmin = adminService.getAllAdmin();
		return listAllAdmin.isEmpty() ?
				ResponseEntity.status(HttpStatus.NOT_FOUND).body(
						new ResponseObject("404 Not Found", "No admin found", "")) :
				ResponseEntity.ok().body(
						new ResponseObject("200 Ok", "Success", listAllAdmin));
	}
	// find by id, name, ...
	@GetMapping(value = {"/{id}", "/{name}"}) // id for now
	public ResponseEntity<ResponseObject> findById(@PathVariable int id) {
		Optional<Admin> foundAdmin = adminService.findAdminById(id);
		return foundAdmin.isPresent() ? 
			ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("200 Ok", "Admin found", foundAdmin)) :
			ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObject("404 Not Found", "Admin not found with id = " + id, ""));
	}
	//update only
	@PutMapping("/{id}")
	public ResponseObject updateAdmin(@RequestBody Admin newAdmin, @PathVariable int id){
		Admin updateAdmin = null;
		try
		{
			//updateAdmin = adminService.updateAdminById(newAdmin, id);
		}catch (Exception e) {
			return new ResponseObject("404 Not Found", "Admin not found or duplicate data" + id, "");
		}
		return new ResponseObject("200 Ok", "Admin updated", updateAdmin);
	}
	//delete
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseObject> deleteAdmin(@PathVariable int id) {
		if (adminService.adminExistedById(id)) {
			try {
				adminService.deleteAdminById(id);
			}
			catch (Exception e) {
				return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
						new ResponseObject("501 Not Implemented", "Something went wrong", ""));
			}
			return ResponseEntity.ok().body(
					new ResponseObject("200 Ok", "Admin deleted", ""));
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
				new ResponseObject("404 Not Found", "Admin not found", ""));
	}
}
