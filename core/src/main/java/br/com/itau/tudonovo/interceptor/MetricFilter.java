package br.com.itau.tudonovo.interceptor;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MetricFilter implements Filter {

	private static final Logger LOGGER = LoggerFactory.getLogger(MetricFilter.class);
	

	@Override
	public void destroy() {

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletResponse servletResponse = (HttpServletResponse) response;
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		
		long before = System.currentTimeMillis();
		
		chain.doFilter(request, response);
		
		long completedTime = System.currentTimeMillis() - before;
		
		LOGGER.info(String.format("{method=%s, path=\"%s\", status= %d}  %d ms", 
				servletRequest.getMethod(), 
				servletRequest.getServletPath(), 
				servletResponse.getStatus(), 
				completedTime));
	}

}

