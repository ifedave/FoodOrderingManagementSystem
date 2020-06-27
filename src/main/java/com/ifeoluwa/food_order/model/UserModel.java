package com.ifeoluwa.food_order.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tbl_user")
public class UserModel{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;
	@Column

	@NotNull
	@Size(min=2, max=255)
	private String firstname;
	@Column
	@NotNull
	@Size(min=2, max=255)
	private String lastname;
	@Column(unique = true)
	@NotNull
	@Size(min = 4,max=255)
	private String email;
	@Column
	@NotNull
	@Size( min=6, max=255)
	private String password;
	@Column
	@NotNull
	private String gender;
	@JoinColumn(name = "authority_id")
	@OneToOne
	private Authorities authority;

	
	public UserModel() {}

	public UserModel(Integer id, String firstname, String lastname, String email, String password, String gender, Authorities authority) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.authority = authority;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Authorities getAuthority() {
		return authority;
	}

	public void setAuthority(Authorities authority) {
		this.authority = authority;
	}
}
