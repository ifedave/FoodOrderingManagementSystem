package com.ifeoluwa.food_order.model;

import javax.persistence.*;

@Entity
@Table(name = "authorities")
public class Authorities {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;
	
	@Column
	private String authority_name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAuthorityName() {
		return authority_name;
	}

	public void setAuthorityName(String authority_name) {
		this.authority_name = authority_name;
	}
}