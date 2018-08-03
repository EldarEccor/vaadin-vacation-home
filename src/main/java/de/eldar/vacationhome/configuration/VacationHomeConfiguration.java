package de.eldar.vacationhome.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.vaadin.flow.spring.VaadinMVCWebAppInitializer;

import de.eldar.vacationhome.VacationHomeApplication;
import lombok.extern.slf4j.Slf4j;

/**
 * Web MVC configuration class. Will loaded by {@link VacationHomeApplication} via {@link VaadinMVCWebAppInitializer}.
 * 
 * Gives us the possiblity influence the underlying configuration for spring's {@link WebMvcAutoConfiguration}.
 */
@Slf4j
@ControllerAdvice
@Configuration
public class VacationHomeConfiguration implements WebMvcConfigurer {
	
	/**
	 * Every Exception we have not handled until this resolves will be 500. 
	 * 
	 * @param e The delinquent
	 */
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	public void handleException(Exception e) {
		log.error("Caught exception in MVC stack: ", e);
	}
	
	@Value("${image.root.dir}")
	private String imageRootDir;
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	    // Add a resource handler for picture files that will be 
		// stored outside our binary in order for the vaadin servlet not to mess with them
		registry
	      .addResourceHandler("/images/**")
	      .addResourceLocations(imageRootDir);
	 }
	
}
