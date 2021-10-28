package com.moz.policemanager.ui.response;

import java.time.OffsetDateTime;

public class UserRest {

	private String code;
	private String email;
	private String lastName;
	private String firstName;
	private OffsetDateTime createOn;
	private OffsetDateTime updateOn;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public OffsetDateTime getCreateOn() {
		return createOn;
	}
	public void setCreateOn(OffsetDateTime createOn) {
		this.createOn = createOn;
	}
	
	public OffsetDateTime getUpdateOn() {
		return updateOn;
	}
	public void setUpdateOn(OffsetDateTime updateOn) {
		this.updateOn = updateOn;
	}	
}
