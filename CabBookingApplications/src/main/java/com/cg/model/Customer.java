package com.cg.model;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer extends AbstractUser{
	@Id
	private int customerId;


	public Customer() {
		super();
	}

	
	
	public Customer(int customerId,String userName, String password, String address, String mobileNumber, String email) {
		super(userName,password,address,mobileNumber,email);
		this.customerId = customerId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + "]";
	}


}
