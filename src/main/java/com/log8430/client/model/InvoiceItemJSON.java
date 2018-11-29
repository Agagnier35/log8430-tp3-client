package com.log8430.client.model;

public class InvoiceItemJSON {
	public ProductJSON productJSON;
	public int quantity;

	public InvoiceItemJSON(ProductJSON productJSON, int quantity) {
		this.productJSON = productJSON;
		this.quantity = quantity;
	}

	public InvoiceItemJSON() {
	}

	@Override
	public String toString() {
		return productJSON.toString() + ", Quantity: " + quantity + "\n";
	}
}
