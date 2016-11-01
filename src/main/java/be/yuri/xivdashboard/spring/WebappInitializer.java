package be.yuri.xivdashboard.spring;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebappInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {


//	@Override
//	protected WebApplicationContext createRootApplicationContext() {
//		WebApplicationContext context = (WebApplicationContext)super.createRootApplicationContext();
//	    ((ConfigurableEnvironment)context.getEnvironment()).setActiveProfiles("Production");
//	    return context;
//	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[]{SpringConfiguration.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[]{ServletConfiguration.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[]{"/s/*"};
	}

	@Override

	public void onStartup(ServletContext servletContext) throws ServletException {
		CharacterEncodingFilter charsetFilter = new CharacterEncodingFilter("UTF-8", true);
		servletContext.addFilter("charsetFilter", charsetFilter);
		super.onStartup(servletContext);
	}

}
