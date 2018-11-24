package code.better.com.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import code.better.com.service.IHelloWorldService;

@Component
@Path("/endpoints")
public class HelloWorld {
	
	@Autowired
	private IHelloWorldService service;

	@GET
	@Path("/first")
	public void firstEndPoint(@Suspended AsyncResponse response) {
		service.firstEndPoint(response);
	}
	
	@GET
	@Path("/second")
	public void secondEndPoint(@Suspended AsyncResponse response) {
		service.secondEndPointWithCombination(response);
	}

}
