package com.log8430.client.FileReader;

public class InvalidCSVException extends Exception {
	public InvalidCSVException(String failureMessage) {
		super(failureMessage);
	}
}
