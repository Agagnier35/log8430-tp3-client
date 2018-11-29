package com.log8430.client.model;

import java.util.ArrayList;
import java.util.List;

public class InvoiceJSON {
	public List<InvoiceItemJSON> items = new ArrayList<>();

	public InvoiceJSON() {
	}

	@Override
	public String toString(){
		return "Items: \n" + items;
	}
}
