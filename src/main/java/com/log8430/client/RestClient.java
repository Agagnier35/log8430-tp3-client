package com.log8430.client;

import javax.ws.rs.client.*;
import javax.ws.rs.core.*;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.jackson.JacksonFeature;

import com.log8430.client.model.InvoiceJSON;

public class RestClient {
	private Client client;
	private String urlService;

	public RestClient(String urlService) {
		ClientConfig cc = new ClientConfig().register(new JacksonFeature());
		client = ClientBuilder.newClient(cc);
		this.urlService = urlService;
	}

	public Response createInvoice(InvoiceJSON invoiceJSON) {
		return client
				.target(urlService + "/invoice")
				.request(MediaType.APPLICATION_JSON)
				.post(Entity.entity(invoiceJSON, MediaType.APPLICATION_JSON));
	}

	public Response getMostBoughtProduct() {
		return client
				.target(urlService + "/top")
				.request(MediaType.APPLICATION_JSON)
				.get(Response.class);
	}
}
