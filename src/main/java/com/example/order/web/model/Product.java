package com.example.order.web.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product implements Serializable {

	private static final long serialVersionUID = 1278738595075109764L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id = 0;

	@Column(name = "catid")
	private int catid;

	@Column(name = "name")
	private String name = "";

	@Column(name = "price")
	private double price = 0.0;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCatid() {
		return catid;
	}

	public void setCatid(int catid) {
		this.catid = (catid == 0) ? 1 : catid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = (name == null || name.trim().length() == 0) ? "UNKNOWN PRODUCT" : name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
