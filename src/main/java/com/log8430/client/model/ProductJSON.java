package com.log8430.client.model;

public class ProductJSON {
	public String name;
	public double price;

	public ProductJSON(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public ProductJSON() {
	}

	@Override
	public String toString() {
		return "Name: " + name + ", price: " + price;
	}
}
