package hcmute.edu.tgdd.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import hcmute.edu.tgdd.utils.Validate;
import hcmute.edu.tgdd.utils.Validate.Type;

@Entity
public class User {
	@Id
	private String phone;
	private String password;
	@Column(nullable = false, unique = true, length = 15)
	private String fullname;
	@Column(nullable = false, unique = true)
	private String address;
	@Column(nullable = false, unique = true)
	private String email;
	private boolean gender;
	
	private Role role;
	public enum Role {
		ROLE_ADMIN,
		ROLE_CUSTOMER;
	}
	
	public User() {
		super();
	}

	public User(String phone, String password, String fullname, String address, String email, boolean gender,
			Role role) {
		super();
		this.phone = phone;
		this.password = password;
		this.fullname = fullname;
		this.address = address;
		this.email = email;
		this.gender = gender;
		this.role = role;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		if (Validate.isWhatever(Type.PHONE, phone))
			this.phone = phone;
		else
			throw new RuntimeException("Incorrect phone format");
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if(Validate.isWhatever(Type.EMAIl, email))
			this.email = email;
		else
			throw new RuntimeException("Incorrect email format");
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [phone=" + phone + ", password=" + password + ", fullname=" + fullname + ", address=" + address
				+ ", email=" + email + ", gender=" + gender + ", role=" + role + "]";
	}
	
	
	
}
