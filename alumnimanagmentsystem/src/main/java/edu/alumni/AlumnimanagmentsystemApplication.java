/*
 * @Author SWASTIKA
 */
package edu.alumni;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.alumni.entity.Alumni;
import edu.alumni.repository.AlumniRepository;



@SpringBootApplication
public class AlumnimanagmentsystemApplication implements CommandLineRunner {
	
	//Constructor Injection
	@Autowired
	private AlumniRepository alumniRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(AlumnimanagmentsystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//Adding Dummy data for testing
		
		
		Alumni a1 = Alumni.builder().name("Swastikia").phone("8098651050").email("sw@gmail.com").grdYear("2022").address("Mumbai").build();
		Alumni a2 = Alumni.builder().name("Monika").phone("7697661050").email("mo@gmail.com").grdYear("2022").address("Pune").build();
		Alumni a3 = Alumni.builder().name("Rakesh").phone("6797221050").email("ra@gmail.com").grdYear("2020").address("Kolkata").build();
		Alumni a4 = Alumni.builder().name("Sanskar").phone("9997221050").email("sa@gmail.com").grdYear("2021").address("Ooty").build();
	
		
		alumniRepository.save(a1);
		alumniRepository.save(a2);
		alumniRepository.save(a3);
		alumniRepository.save(a4);
	
		System.out.println("--------------------------All saved-------------------------");

		
		
	}

}
