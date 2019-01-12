package com.luv2code.springdemo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.domain.Persistable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="customer")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Customer implements Serializable, Persistable<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2885688765934536490L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@NotNull(message="The first name is required!")
	@NotBlank(message="The first name cannot be blank!")
	@NotEmpty(message="The first name cannot be empty!")
	@Column(name="first_name")
	private String firstName;

	
	@NotNull(message="The last name is required!")
	@NotBlank(message="The last name cannot be blank!")
	@NotEmpty(message="The last name cannot be empty!")
	@Column(name="last_name")
	private String lastName;
	
	
	@NotNull(message="The e-mail is required!")
	@NotBlank(message="The e-mail cannot be blank!")
	@NotEmpty(message="The e-mail cannot be empty!")
	@Column(name="email")
	private String email;
	
	public Customer() {
		
	}

	@Override
	public Integer getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}

	@Override
	public boolean isNew() {
		return this.id == 0 || this.id == null;
	}
		
}





