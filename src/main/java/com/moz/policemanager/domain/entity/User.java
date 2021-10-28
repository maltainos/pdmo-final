package com.moz.policemanager.domain.entity;

import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name= "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String code;
	
	@NotBlank
	@Email
	@Size(max = 255)
	private String email;
	
	@NotBlank
	@Size(max = 255)
	private String lastName;
	
	@NotBlank
	@Size(max = 255)
	private String firstName;
	
	@NotBlank
	@Size(max = 255)
	private String encryptedPassword;
	
	@Column(columnDefinition="boolean default false")
	private boolean emailVerificaionStatus;
	
	@Size(max = 255)
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", code=" + code + ", email=" + email + ", lastName=" + lastName + ", firstName="
				+ firstName + ", encryptedPassword=" + encryptedPassword + ", emailVerificaionStatus="
				+ emailVerificaionStatus + ", emailVerificationToken=" + emailVerificationToken + ", createOn="
				+ createOn + ", updateOn=" + updateOn + "]";
	}
	
}
