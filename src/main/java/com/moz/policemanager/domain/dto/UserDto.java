package com.moz.policemanager.domain.dto;

import java.time.OffsetDateTime;

public class UserDto {
	
	private Long id;
	private String code;
	private String email;
	private String lastName;
	private String firstName;
	private String password;
	private String encryptedPassword;
	private boolean emailVerificaionStatus = false;
	private String emailVerificationToken;
	private OffsetDateTime createOn;
	private OffsetDateTime updateOn;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
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
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEncryptedPassword() {
		return encryptedPassword;
	}
	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}
	
	public boolean isEmailVerificaionStatus() {
		return emailVerificaionStatus;
	}
	public void setEmailVerificaionStatus(boolean emailVerificaionStatus) {
		this.emailVerificaionStatus = emailVerificaionStatus;
	}
	
	public String getEmailVerificationToken() {
		return emailVerificationToken;
	}
	public void setEmailVerificationToken(String emailVerificationToken) {
		this.emailVerificationToken = emailVerificationToken;
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
	@Override
	public String toString() {
		return "UserDto [id=" + id + ", code=" + code + ", email=" + email + ", lastName=" + lastName + ", firstName="
				+ firstName + ", password=" + password + ", encryptedPassword=" + encryptedPassword
				+ ", emailVerificaionStatus=" + emailVerificaionStatus + ", emailVerificationToken="
				+ emailVerificationToken + ", createOn=" + createOn + ", updateOn=" + updateOn + "]";
	}
	
}
