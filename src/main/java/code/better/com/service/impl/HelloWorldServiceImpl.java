package code.better.com.service.impl;

import java.util.concurrent.CompletableFuture;

import javax.ws.rs.container.AsyncResponse;

import org.springframework.stereotype.Service;

import code.better.com.core.Asynchronus;
import code.better.com.service.IHelloWorldService;

@Service
public class HelloWorldServiceImpl implements IHelloWorldService {

	@Override
	public void firstEndPoint(AsyncResponse response) {
		firstEndPointBussiness()
		.thenApply(response::resume)
		.exceptionally(response::resume);
		
	}
	
	@Asynchronus
	private CompletableFuture<String> firstEndPointBussiness(){
		return CompletableFuture.completedFuture("First End Point Bussiness Logic");
	}
	
	@Asynchronus
	private CompletableFuture<String> secondEndPointBussiness(){
		return CompletableFuture.completedFuture("Second End Point bussiness Logic");
	}

	@Override
	public void secondEndPointWithCombination(AsyncResponse response) {
		CompletableFuture<String> first=firstEndPointBussiness();
		CompletableFuture<String> second=secondEndPointBussiness();
		first.thenCombine(second,(firstString,secondString)->
		String.format("First String %s and Second String %s", firstString,secondString))
		.thenApply(response::resume)
		.exceptionally(response::resume);
	}

}
