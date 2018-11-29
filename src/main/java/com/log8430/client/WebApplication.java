package com.log8430.client;

import java.io.IOException;
import java.util.Scanner;

import javax.ws.rs.core.Response;

import com.log8430.client.FileReader.FileReader;
import com.log8430.client.model.InvoiceJSON;

public class WebApplication {

	public static void main(String[] args) throws Exception {
		System.out.println("Enter the url of the service");
		Scanner consoleScanner = new Scanner(System.in);
		String urlService = consoleScanner.nextLine().trim();

		RestClient client = new RestClient(urlService);
		boucle:
		while (true) {
			System.out.println("Enter the command (add, get, exit, help)");
			String command = consoleScanner.nextLine();

			switch (command) {
				case "add": {
					System.out.println("Enter the location of the CSV file");
					String filePath = consoleScanner.nextLine().trim().replace("\"", "");
					try {
						InvoiceJSON invoiceJSON = new FileReader(filePath).readFile();

						Response response = client.createInvoice(invoiceJSON);
						System.out.println(response.getStatus());
						System.out.println(response.getEntity());
					} catch (IOException e) {
						System.out.println(e.getMessage());
					}
					break;
				}
				case "get": {
					Response response = client.getMostBoughtProduct();
					System.out.println(response.getStatus());
					System.out.println(response.getEntity());
					break;
				}
				case "exit": {
					break boucle;
				}
				case "help":
				default: {
					System.out.println("Commands: \n"
							+ "add: Add invoices from a specified CSV file path\n"
							+ "get: Get the most bought product recorded in the DB\n"
							+ "exit: exit the client");
					break;
				}
			}
		}
	}
}
