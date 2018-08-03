package de.eldar.vacationhome;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Our application class. Loads the boot magic and makes stuff happen :)
 */
@SpringBootApplication
public class VacationHomeApplication {  
 
	/**
	 * Canonical main for the spring boot application startup. 
	 * 
	 * @param args CLI args
	 */
	public static void main(String[] args) {
		SpringApplication.run(VacationHomeApplication.class, args);
	}

}
