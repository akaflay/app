package code.better.com.runtime;

import java.util.HashSet;
import java.util.Set;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import code.better.com.core.AspectOriented;
import code.better.com.core.Filter;
import code.better.com.resource.HelloWorld;

@Component
public class JerseyConfiguration extends ResourceConfig {

	public JerseyConfiguration() {
		Set<Class<?>> classes = new HashSet<>();
        classes.add(HelloWorld.class);
        classes.add(Filter.class);
        classes.add(AspectOriented.class);
        registerClasses(classes);
	}

}
