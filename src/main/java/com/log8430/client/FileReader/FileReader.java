package com.log8430.client.FileReader;

import java.io.File;
import java.io.IOException;
import java.util.*;

import com.log8430.client.model.*;

public class FileReader {
	private static final String SEPARATOR = ",";
	private Scanner scanner;

	public FileReader(String filePath) throws IOException {
		File file = new File(filePath);
		scanner = new Scanner(file);
	}

	public Invoice readFile() throws InvalidCSVException {
		validateScanner("Missing Header");
		String header = scanner.nextLine();

		Invoice invoice = new Invoice();
		List<InvoiceItem> invoiceItems = new ArrayList<>();
		while (scanner.hasNextLine()) {
			String productString = scanner.nextLine();
			String[] productParts = productString.split(SEPARATOR);

			Product product = new Product(productParts[0], Double.parseDouble(productParts[1]));
			int quantity = Integer.parseInt(productParts[2]);

			InvoiceItem invoiceItem = new InvoiceItem(product, quantity);
			invoiceItems.add(invoiceItem);
		}
		invoice.items = invoiceItems;
		return invoice;
	}

	public void validateScanner(String failureMessage) throws InvalidCSVException {
		if (!scanner.hasNextLine()) {
			throw new InvalidCSVException(failureMessage);
		}
	}
}
