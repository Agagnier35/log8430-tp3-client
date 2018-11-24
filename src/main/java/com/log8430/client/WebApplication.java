package com.log8430.client;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import javax.ws.rs.core.Response;

import com.log8430.client.FileReader.FileReader;
import com.log8430.client.model.*;

public class WebApplication {

	public static void main(String[] args) throws Exception {
		RestClient client = new RestClient();
		boucle:
		while (true) {
			System.out.println("Enter the command (add, get, exit, help)");
			Scanner consoleScanner = new Scanner(System.in);
			String command = consoleScanner.nextLine();

			switch (command) {
				case "add": {
					System.out.println("Enter the location of the CSV file");
					String filePath = consoleScanner.nextLine();
					try {
						Invoice invoice = new FileReader(filePath).readFile();

						Response response = client.createInvoice(invoice);
						System.out.println(response.getStatus());
					} catch (IOException e) {
						System.out.println(e.getMessage());
					}
					break;
				}
				case "get": {
					List<MostBoughtProduct> product = client.getMostBoughtProduct();
					System.out.println(product.toString());
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
