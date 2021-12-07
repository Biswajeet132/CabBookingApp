package com.cg.model;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Admin extends AbstractUser{
	@Id
	private int adminId;
	
	public Admin() {
		super();
	}

	public Admin(int adminId,String userName, String password, String address, String mobileNumber, String email) {
		super(userName,password,address,mobileNumber,email);
		this.adminId = adminId;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + "]";
	}
	
	
}
