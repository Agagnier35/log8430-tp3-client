package com.log8430.client;

import java.util.List;

import javax.ws.rs.client.*;
import javax.ws.rs.core.*;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.jackson.JacksonFeature;

import com.log8430.client.model.*;

public class RestClient {
	private Client client;
	private static final String URL_SERVICE = "http://localhost:8080/rest";

	public RestClient() {
		ClientConfig cc = new ClientConfig().register(new JacksonFeature());
		client = ClientBuilder.newClient(cc);
	}

	public Response createInvoice(Invoice invoice) {
		return client
				.target(URL_SERVICE + "/invoice")
				.request(MediaType.APPLICATION_JSON)
				.post(Entity.entity(invoice, MediaType.APPLICATION_JSON));
	}

	public List<MostBoughtProduct> getMostBoughtProduct(){
		return client
				.target(URL_SERVICE + "/top")
				.request(MediaType.APPLICATION_JSON)
				.get(new GenericType<List<MostBoughtProduct>>(){});
	}
}
