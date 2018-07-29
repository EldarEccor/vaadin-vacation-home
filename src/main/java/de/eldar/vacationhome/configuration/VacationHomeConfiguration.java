package de.eldar.vacationhome.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.vaadin.flow.spring.VaadinMVCWebAppInitializer;

/**
 * Configuration that will be loaded by {@link VaadinMVCWebAppInitializer}
 * defining the MVC parts and other beans we want outside of vaadin or just
 * plain in our context.
 */
@Configuration
@EnableWebMvc
public class VacationHomeConfiguration implements WebMvcConfigurer {
	
	@Value("${image.root.dir}")
	private String imageRootDir;
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	    registry
	      .addResourceHandler("/images/**")
	      .addResourceLocations(imageRootDir);
	 }
	
}
