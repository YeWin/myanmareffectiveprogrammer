package com.mep.log;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	private static final String MDC_KEY_SESSIONID = "sessionId";

	private static final String MDC_KEY_IP_ADDRESS = "ipAddress";
	
	@Autowired
	private HttpServletRequest request;

	private static final Logger logger = LoggerFactory
			.getLogger(LoggingAspect.class);
	
	@Pointcut(value = "execution(public * *(..)) && within(com.mep..service..*)")
	private void logServicePointcut() {
	}

	@Pointcut(value = "execution(public * *(..)) && within(com.mep..controller..*)")
	private void logControllerPointcut() {
	}

	@Before("logControllerPointcut() || logServicePointcut()")
	public void loggingServiceBefore(JoinPoint jointPoint) {
		
		String methodName = getMethodName(jointPoint);
		
		addIpAddressAndSessionId();
		
		logger.debug(methodName + "method has been started.");

	}

	@AfterReturning("logControllerPointcut() || logServicePointcut()")
	public void loggingServiceAfterReturn(JoinPoint jointPoint) {
		
		String methodName = getMethodName(jointPoint);
		
		addIpAddressAndSessionId();
		
		logger.debug(methodName + "method has been successfully finished.");
	}

	@AfterThrowing(pointcut = "logControllerPointcut() || logServicePointcut()", throwing = "exception")
	public void loggingServiceAfterThrow(JoinPoint jointPoint, RuntimeException exception) {
		
		String methodName = getMethodName(jointPoint);
		
		addIpAddressAndSessionId();
		
		logger.error(methodName + "method has been failed.");
		logger.error("Exception is ", exception);
	}
	
	public String getMethodName(JoinPoint jointPoint) {
		MDC.clear();
		
		Signature signature = jointPoint.getSignature();
		String declareTypeName = signature.getDeclaringTypeName();
		String name = signature.getName();
		
		return declareTypeName + "." + name + "() ";		
	}
	
	public void addIpAddressAndSessionId() {
		
		MDC.putCloseable(MDC_KEY_IP_ADDRESS, request.getRemoteAddr());

		if (request.getSession() != null) {
			MDC.putCloseable(MDC_KEY_SESSIONID, request.getSession().getId());
		}		
	}
}
