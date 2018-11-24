package code.better.com.core;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
/**
 * 
 * Make sure to add the @Provider annotatoion to let jersey know that
 * we want to trap request here before hitting any end point.
 * This is used basically for authorization and adding 
 * request id that is used during debugging
 *
 */
@Provider
@Component
public class Filter implements ContainerRequestFilter {
	
	private static Logger LOGGER = LoggerFactory.getLogger(Filter.class);


	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		LOGGER.debug("In filter");
		
	}

	
}
