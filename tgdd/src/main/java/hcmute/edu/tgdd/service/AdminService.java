package hcmute.edu.tgdd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hcmute.edu.tgdd.model.Admin;
import hcmute.edu.tgdd.repository.AdminRepository;

@Service
public class AdminService {
	@Autowired
	private AdminRepository adminRepository;

	public AdminService() {
		super();
	}

	public AdminService(AdminRepository adminRepository) {
		super();
		this.adminRepository = adminRepository;
	}
	
	public List<Admin> getAllAdmin() {
		return adminRepository.findAll();
	}
	public Optional<Admin> findAdminById(int id) {
		return adminRepository.findById(id);
	}
	public Admin updateOrInsert(Admin admin) {
		return adminRepository.save(admin);
	}
	public Admin updateAdminById(Admin newAdmin, int id) throws Exception{
		Admin updateAdmin = findAdminById(id)
				.map(admin -> {
					admin.setAddress(newAdmin.getAddress());
					admin.setFullname(newAdmin.getFullname());
					admin.setEmail(newAdmin.getEmail());
					admin.setPhone(newAdmin.getPhone());
					
					admin.setUsername(newAdmin.getUsername());
					admin.setPassword(newAdmin.getPassword());
					
					return updateOrInsert(newAdmin);
				}).orElseThrow();
		return updateAdmin;
	}
	public void deleteAdminById(int id) throws Exception{
		adminRepository.deleteById(id);
	}
	public boolean adminExistedById(int id) {
		return adminRepository.existsById(id);
	}
}
