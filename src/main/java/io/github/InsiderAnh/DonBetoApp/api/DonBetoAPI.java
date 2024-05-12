package io.github.InsiderAnh.DonBetoApp.api;

import java.util.concurrent.CompletableFuture;

import org.bson.Document;

import io.github.InsiderAnh.DonBetoApp.MainApp;
import io.github.InsiderAnh.backendapi.client.delta.BetoClient;
import lombok.experimental.UtilityClass;

@UtilityClass
public class DonBetoAPI {
		
	public CompletableFuture<Document> registerUser(String userName, String password, String role, String authorization) {
		CompletableFuture<Document> completableFuture = new CompletableFuture<>();
		getBetoClient().registerUser(userName, password, role, authorization).then(document -> completableFuture.complete(document));
		return completableFuture;
	}
	
	public CompletableFuture<Document> loginUser(String userName, String password) {
		CompletableFuture<Document> completableFuture = new CompletableFuture<>();
		getBetoClient().loginUser(userName, password).then(document -> completableFuture.complete(document));
		return completableFuture;
	}
	
	public CompletableFuture<Document> addProduct(String id, String name, String description, String category, double price, int stock) {
		CompletableFuture<Document> completableFuture = new CompletableFuture<>();
		getBetoClient().addProduct(id, name, description, category, price, stock).then(document -> completableFuture.complete(document));
		return completableFuture;
	}
	
	public CompletableFuture<Document> updateProduct(String id, String name, String description, String category, double price, int stock) {
		CompletableFuture<Document> completableFuture = new CompletableFuture<>();
		getBetoClient().updateProduct(id, name, description, category, price, stock).then(document -> completableFuture.complete(document));
		return completableFuture;
	}
	
	public CompletableFuture<Document> removeProduct(String id) {
		CompletableFuture<Document> completableFuture = new CompletableFuture<>();
		getBetoClient().removeProduct(id).then(document -> completableFuture.complete(document));
		return completableFuture;
	}
	
	public CompletableFuture<Document> getProduct(String id, String name) {
		CompletableFuture<Document> completableFuture = new CompletableFuture<>();
		getBetoClient().getProduct(id, name).then(document -> completableFuture.complete(document));
		return completableFuture;
	}
	
	public BetoClient getBetoClient() {
		return MainApp.getInstance().getDbManager().getDbClient().getDataFetcher().getPlayerClient();
	}

}