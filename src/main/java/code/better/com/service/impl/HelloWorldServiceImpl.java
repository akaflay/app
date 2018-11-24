package code.better.com.service.impl;

import java.util.concurrent.CompletableFuture;

import javax.ws.rs.container.AsyncResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import code.better.com.core.Asynchronus;
import code.better.com.core.JsonUtils;
import code.better.com.service.IHelloWorldService;

@Service
public class HelloWorldServiceImpl implements IHelloWorldService {

	@Autowired
	RestTemplate restTemplate;
	
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

	@Override
	@HystrixCommand(fallbackMethod="fallBack")
	public void curcuitBreaker(AsyncResponse response) {
		curcuitBreaker().thenApply(response::resume);
	}
	
	@Asynchronus
	private CompletableFuture<String> curcuitBreaker(){
		String response=restTemplate.getForObject("http://localhost:8888/app/default", String.class);
		return CompletableFuture.completedFuture(response);
	}
	
	public void fallBack(AsyncResponse response) {
		ObjectNode responseNode=JsonUtils.createObjectNode();
		responseNode.put("response", "Response from fall Back Method");
		response.resume(responseNode.toString());
	}

}
