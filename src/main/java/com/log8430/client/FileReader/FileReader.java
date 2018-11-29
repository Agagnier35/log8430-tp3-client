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

	public InvoiceJSON readFile() throws InvalidCSVException {
		validateScanner("Missing Header");
		String header = scanner.nextLine();

		InvoiceJSON invoiceJSON = new InvoiceJSON();
		List<InvoiceItemJSON> invoiceItemJSONS = new ArrayList<>();
		while (scanner.hasNextLine()) {
			String productString = scanner.nextLine();
			String[] productParts = productString.split(SEPARATOR);

			ProductJSON productJSON = new ProductJSON(productParts[0], Double.parseDouble(productParts[1]));
			int quantity = Integer.parseInt(productParts[2]);

			InvoiceItemJSON invoiceItemJSON = new InvoiceItemJSON(productJSON, quantity);
			invoiceItemJSONS.add(invoiceItemJSON);
		}
		invoiceJSON.items = invoiceItemJSONS;
		return invoiceJSON;
	}

	public void validateScanner(String failureMessage) throws InvalidCSVException {
		if (!scanner.hasNextLine()) {
			throw new InvalidCSVException(failureMessage);
		}
	}
}
