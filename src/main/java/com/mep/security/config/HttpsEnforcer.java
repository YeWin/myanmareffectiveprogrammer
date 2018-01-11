package com.mep.security.config;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mep.log.LoggingAspect;

import java.io.IOException;

public class HttpsEnforcer implements Filter {

    private FilterConfig filterConfig;
    
    private static final Logger logger = LoggerFactory
			.getLogger(LoggingAspect.class);

    public static final String X_FORWARDED_PROTO = "x-forwarded-proto";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        if (request.getHeader(X_FORWARDED_PROTO) != null) {
            if (request.getHeader(X_FORWARDED_PROTO).indexOf("https") != 0) {
                response.sendRedirect("https://" + request.getServerName() + request.getPathInfo() == null ? "" : request.getPathInfo());
                return;
            }
        }

        logger.debug("Server Name = " + request.getServerName());
        logger.debug("PathInfo Name = " + request.getPathInfo());
        filterChain.doFilter(request, response);
    }

	@Override
	public void destroy() {
		// do nothing
	}
}
