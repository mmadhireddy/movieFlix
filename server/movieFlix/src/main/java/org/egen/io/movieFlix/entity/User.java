package org.egen.io.movieFlix.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;

@Scope
@Entity
@Table
@NamedQueries({
	@NamedQuery(name = "User.findAll", query = "SELECT u from User u"),
	@NamedQuery(name = "User.findByEmail", query = "SELECT u from User u where u.email=:pEmail")
})
public class User {
	@Id
	@Column(name="USERID")
	private String id;
	private String firstName;
	private String lastName;
	private String password;
	private Boolean admin;
	
	@Column(unique = true)
	private String email;
	
	private int		 phone;

	public User() {
		id = UUID.randomUUID().toString();
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}
	
	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", password=" + password
				+ ", email=" + email + ", phone=" + phone + "]";
	}
	
	
	
}
