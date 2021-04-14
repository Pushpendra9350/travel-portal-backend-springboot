package com.nagarro.travel_portal_backend_app.model;


/**
 * This is Employee Model
 * @author Pushpendra Kumar
 * @Version 1.0
 * @since 2020-05-05
 * 
 */

import java.io.Serializable;

import java.security.NoSuchAlgorithmException;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.nagarro.travel_portal_backend_app.model.GeneratePaaword;



@Entity
@Table(name="employees")
public class Employee implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="empId")
	private long empId;
	
	@Column(name="firstName")
	@NotNull(message = "The first name must not be null")
	@Size(max = 50)
	private String firstName;
	
	@Column(name="lastName")
	@NotNull(message = "The last name must not be null")
	@Size(max = 50)
	private String lastName;
	
	@Column(name="businessUnit")
	@NotNull(message = "The business unit must not be null")
	@Size(max = 50)
	private String businessUnit;
	
	@Column(name="title")
	@NotNull(message = "The title must not be null")
	@Size(max = 50)
	private String title;
	
	@Column(name="email")
	@NotNull(message = "The email must not be null")
	@Size(max = 50)
	private String email;
	
	@Column(name="telephone")
	@NotNull(message = "The telephone must not be null")
	@Size(max = 50)
	private String telephone;
	
	@Column(name="addressOne")
	@NotNull(message = "The addressOne must not be null")
	@Size(max = 100)
	private String addressOne;
	
	@Column(name="addressTwo")
	@Size(max = 100)
	private String addressTwo;
	
	@Column(name="city")
	@NotNull(message = "The city must not be null")
	@Size(max = 50)
	private String city;
	
	@Column(name="state")
	@NotNull(message = "The state must not be null")
	@Size(max = 50)
	private String state;
	
	@Column(name="zip")
	@NotNull(message = "The zip must not be null")
	@Size(max = 50)
	private String zip;
	
	@Column(name="country")
	@NotNull(message = "The county must not be null")
	@Size(max = 50)
	private String country;
	
	@Column(name="passward")
	@NotNull(message = "The password must not be null")
	@Size(max = 8)
	private String passward;
	
	
	
	
	// one to many
//	@OneToMany(mappedBy = "employees", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private Set<RequestedTickets> requested_tickets;
	
	
	
//	public Set<RequestedTickets> getRequested_tickets() {
//		return requested_tickets;
//	}
//	public void setRequested_tickets(Set<RequestedTickets> requested_tickets) {
//		this.requested_tickets = requested_tickets;
//	}
	public long getEmpId() {
		return empId;
	}
	public void setEmpId(long empId) {
		this.empId = empId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getBusinessUnit() {
		return businessUnit;
	}
	public void setBusinessUnit(String businessUnit) {
		this.businessUnit = businessUnit;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAddressOne() {
		return addressOne;
	}
	public void setAddressOne(String addressOne) {
		this.addressOne = addressOne;
	}
	public String getAddressTwo() {
		return addressTwo;
	}
	public void setAddressTwo(String addressTwo) {
		this.addressTwo = addressTwo;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPassward() {
		return passward;
	}
	public void setPassward(String passward) {
		try {
			this.passward = GeneratePaaword.toHexString(GeneratePaaword.getSHA(getFirstName()+getEmail()));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", firstName=" + firstName + ", lastName=" + lastName + ", businessUnit="
				+ businessUnit + ", title=" + title + ", email=" + email + ", telephone=" + telephone + ", addressOne="
				+ addressOne + ", addressTwo=" + addressTwo + ", city=" + city + ", state=" + state + ", zip=" + zip
				+ ", country=" + country + ", passward=" + passward + "]";
	}
	
	

}
