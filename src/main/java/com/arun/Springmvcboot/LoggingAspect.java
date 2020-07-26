package com.arun.Springmvcboot;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(LoggingAspect.class);
	
	@Before("execution(public * com.arun.Springmvcboot.AlienController.getAliens())")
	public void logBefore() {
		LOGGER.info("get aliens method from aspect BEFORE");
		
	}
	
	@After("execution(public * com.arun.Springmvcboot.AlienController.getAliens())")
	public void logAfter() {
		LOGGER.info("get aliens method from aspect AFTER");
		
	}
}
