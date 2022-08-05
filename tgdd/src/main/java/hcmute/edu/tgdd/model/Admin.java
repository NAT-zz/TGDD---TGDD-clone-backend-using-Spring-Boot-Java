package hcmute.edu.tgdd.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false, unique = true, length = 15)
	private String username;
	private String password;
	private String fullname;
	@Column(nullable = false, unique = true, length = 10)
	private String phone;
	private String address;
	@Column(nullable = false, unique = true, length = 300)
	private String email;
	
	public Admin() {
		super();
	}

	public Admin(String username, String password, String fullname, String phone, String address,
			String email) {
		super();
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.phone = phone;
		this.address = address;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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
		this.email = email;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", username=" + username + ", password=" + password + ", fullname=" + fullname
				+ ", phone=" + phone + ", address=" + address + ", email=" + email + "]";
	}
	
}
