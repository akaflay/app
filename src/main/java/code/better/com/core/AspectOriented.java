package code.better.com.core;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

@Aspect
public class AspectOriented {

	private static Logger LOGGER = LoggerFactory.getLogger(AspectOriented.class);

	@Pointcut("@annotation(Asynchronus)")
	public void annotationPointCutDefinition() {
	}

	@Pointcut("execution(* *(..))")
	public void atExecution() {
	}

	@Around("annotationPointCutDefinition() && atExecution()")
	public Object around(ProceedingJoinPoint jointPoing){
		LOGGER.debug("In aspect class");
		return processJointPoing(jointPoing);
	}

	public Object processJointPoing(ProceedingJoinPoint jointPoing) {
		ApplicationContext ctx = ApplicationContextUtils.getApplicationContext();
		ExecutorService executorService = (ExecutorService) ctx.getBean("serviceThread");
		try {
			return executorService.submit(new Callable<Object>() {
				public Object call() {
					try {
						return jointPoing.proceed();
					} catch (Throwable e) {
						LOGGER.error("Error running jointpoint proceed");
					}
					return null;
				}
			}).get(20, TimeUnit.SECONDS);
		} catch (Exception e) {
			LOGGER.error("Too long for the task to complete");
			return null;
		}

	}

}
