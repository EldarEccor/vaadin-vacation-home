package de.eldar.vacationhome;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.vaadin.flow.spring.VaadinMVCWebAppInitializer;

import de.eldar.vacationhome.configuration.VacationHomeConfiguration;

/**
 * Our application class. Loads the boot magic and makes stuff happen :)
 */
@SpringBootApplication
public class VacationHomeApplication extends VaadinMVCWebAppInitializer{  
 
	/**
	 * Canonical main for the spring boot application startup. 
	 * 
	 * @param args CLI args
	 */
	public static void main(String[] args) {
		SpringApplication.run(VacationHomeApplication.class, args);
	}

	@Override
	protected Collection<Class<?>> getConfigurationClasses() {
		return Arrays.asList(VacationHomeConfiguration.class);
	}

}
