package com.log8430.client.model;

public class MostBoughtProductJSON {
	public ProductJSON productJSON;
	public int nbOfTimes;

	public MostBoughtProductJSON(ProductJSON productJSON, int nbOfTimes) {
		this.productJSON = productJSON;
		this.nbOfTimes = nbOfTimes;
	}

	public MostBoughtProductJSON() {
	}

	@Override
	public String toString() {
		return productJSON.toString() + "bought " + nbOfTimes + " times.";
	}
}
