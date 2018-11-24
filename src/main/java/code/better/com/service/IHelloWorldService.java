package code.better.com.service;

import javax.ws.rs.container.AsyncResponse;

public interface IHelloWorldService {

	void firstEndPoint(AsyncResponse response);
	void secondEndPointWithCombination(AsyncResponse response);

}