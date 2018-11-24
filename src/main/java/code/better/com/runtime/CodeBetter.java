package code.better.com.runtime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"code.better.com"})
public class CodeBetter {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(CodeBetter.class, args);
	}

}
