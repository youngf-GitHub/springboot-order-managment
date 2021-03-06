package com.example.order.web.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order implements Serializable {

	private static final long serialVersionUID = 6896302777479364286L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id = 1;

	@Column(name = "prdid")
	private int prdid;

	@Column(name = "quantity")
	private int quantity = 1;

	@Column(name = "contact")
	private String contact = "";

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPrdid() {
		return prdid;
	}

	public void setPrdid(int prdId) {
		this.prdid = (prdId == 0) ? 1 : prdId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
}
