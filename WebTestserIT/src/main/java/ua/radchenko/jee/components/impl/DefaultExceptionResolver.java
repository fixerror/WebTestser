package ua.radchenko.jee.components.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;

import ua.radchenko.jee.exceptions.InvalidUserInputException;

/**
 * 
 * @author radchenko.as
 * @version 1.0
 */
@Component
public class DefaultExceptionResolver extends AbstractHandlerExceptionResolver {
	private static final Logger LOGGER = Logger
			.getLogger(DefaultExceptionResolver.class);

	public DefaultExceptionResolver() {
		setOrder(0);
	}

	@Override
	protected ModelAndView doResolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		try {
			Throwable causeException = ex.getCause() == null ? ex : ex
					.getCause();
			if (handler != null
					&& !(causeException instanceof InvalidUserInputException)) {
				Logger.getLogger(handler.getClass()).error("", ex);
			}
			LOGGER.warn("Unsupported exception: " + ex.getClass(), ex);
			return new ModelAndView("redirect:/error?url="
					+ request.getRequestURI());
		} catch (Exception e) {
			LOGGER.error("Can't send error", e);
			return new ModelAndView();
		}
	}

	@Override
	protected void logException(Exception ex, HttpServletRequest request) {
		// do nothing
	}

	@Override
	protected boolean shouldApplyTo(HttpServletRequest request, Object handler) {
		return true;
	}

	/*
	 * public void doFilter(HttpServletRequest request, HttpServletResponse
	 * response, FilterChain chain) throws IOException, ServletException{ String
	 * u=request.getRequestURI(); long time =System.currentTimeMillis(); try{
	 * if(contains(u)){
	 * System.out.println("\n\n\n********************** start : "
	 * +u+"********************"); HibernateDebugUtils.turnOnShowSQL(); }
	 * chain.doFilter(request, response); }finally{ if(contains(u)){
	 * LOGGER.debug
	 * ("Time for loading is "+(System.currentTimeMillis()-time+"ms for url"
	 * +u)); } if(contains(u)){ HibernateDebugUtils.turnOffShowSQL();
	 * System.out.
	 * println("\n\n\n********************** stop : "+u+"********************");
	 * }
	 * 
	 * }
	 * 
	 * }
	 */

}
