package com.mep.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ModelAndView handleConflict(HttpServletRequest req, Exception e)
			throws Exception {

		if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null)
			throw e;

		ModelAndView mav = new ModelAndView("/error/errors");

		return mav;
	}

	@ExceptionHandler(ApplicationException.class)
	public ModelAndView handleApplicationException(HttpServletRequest req,
			Exception e) throws Exception {
		if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null)
			throw e;
		ModelAndView mav = new ModelAndView("/error/errors");

		return mav;
	}

	@ExceptionHandler(SystemException.class)
	public ModelAndView handleSystemException(HttpServletRequest req,
			Exception e) throws Exception {
		if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null)
			throw e;
		ModelAndView mav = new ModelAndView("/error/errors");
		return mav;
	}
}
