package code.better.com.config;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

	@Bean(name = "serviceThread")
	public ExecutorService getThreadPool() {
		return Executors.newFixedThreadPool(5);
	}

}
