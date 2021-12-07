package com.cg.model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Driver extends AbstractUser{
	@Id
	private int driverId;
	private String licenseNumber;
	@OneToOne
	private Cab cab;
	private float rating;
	
	
	public Driver() {
		super();
	}
	
	public Driver(int driverId, String licenseNumber, Cab cab, float rating,String userName, String password, String address, String mobileNumber, String email) {
		super(userName,password,address,mobileNumber,email);
		this.driverId = driverId;
		this.licenseNumber = licenseNumber;
		this.cab = cab;
		this.rating = rating;
	}
	
	public int getDriverId() {
		return driverId;
	}
	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}
	public String getLicenseNumber() {
		return licenseNumber;
	}
	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}
	public Cab getCab() {
		return cab;
	}
	public void setCab(Cab cab) {
		this.cab = cab;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Driver [driverId=" + driverId + ", licenseNumber=" + licenseNumber + ", cab=" + cab + ", rating="
				+ rating + "]";
	}
}
