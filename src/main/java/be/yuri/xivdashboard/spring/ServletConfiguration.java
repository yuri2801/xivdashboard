package be.yuri.xivdashboard.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import be.yuri.xivdashboard.controller.MainController;

@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses=MainController.class)//"be.yuri.xivdashboard.controller")
public class ServletConfiguration  extends WebMvcConfigurerAdapter {
	
	@Bean 
	CharacterEncodingFilter characterEncodingFilter(){
		CharacterEncodingFilter encFilter;

		encFilter = new CharacterEncodingFilter();

		encFilter.setEncoding("UTF-8");
		encFilter.setForceEncoding(true);

		return encFilter;
	}

	@Bean
	public ViewResolver viewResolver(){
		UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
    	//viewResolver.setTemplateEngine(templateEngine());
    	return viewResolver;
	}

	@Bean
	public ReloadableResourceBundleMessageSource messageSource() {
		ReloadableResourceBundleMessageSource messages = new ReloadableResourceBundleMessageSource();
		messages.addBasenames("/WEB-INF/messages");
		messages.setDefaultEncoding("UTF-8");
		return messages;
	}
}
