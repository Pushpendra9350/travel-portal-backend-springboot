package com.nagarro.travel_portal_backend_app.model;


/**
 * This is Admin Model
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

@Entity
@Table(name="admin")
public class Admin implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="adminId")
	private long adminId;
	
	@Column(name="fullName")
	@NotNull(message = "The full name must not be null")
	@Size(max = 60)
	private String fullName;
	
	@Column(name="email")
	@NotNull(message = "The email must not be null")
	@Size(max = 60)
	private String email;
	
	@Column(name="passward")
	@NotNull(message = "The password must not be null")
	@Size(max = 8)
	private String passward;

	public long getAdminId() {
		return adminId;
	}

	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassward() {
		return passward;
	}

	public void setPassward(String passward) {
		try {
			this.passward = GeneratePaaword.toHexString(GeneratePaaword.getSHA(getFullName()+getEmail()));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
	
	
	
	

}
