package org.ops4j.pax.web.itest.base.support;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class SimpleOnlyFilter implements Filter {

	@Override
	public void init(FilterConfig config) throws ServletException {
		System.out.println(config.getServletContext().getContextPath());
	}

	public void doFilter(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		servletResponse.setContentType("text/html");
		((HttpServletResponse) servletResponse).setStatus(HttpServletResponse.SC_OK);
		servletResponse.getWriter().println("<h1>Hello Whiteboard Filter</h1>");

		filterChain.doFilter(servletRequest, servletResponse);
	}

	public void destroy() {
	}
}