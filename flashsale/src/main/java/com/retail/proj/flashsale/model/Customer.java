package com.retail.proj.flashsale.model;

import javax.persistence.*;

@Entity
@Table(name = "customers")

public class Customer {

    @Id
    
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
    
}