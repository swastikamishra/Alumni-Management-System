package edu.alumni;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import org.springframework.test.annotation.Rollback;

import edu.alumni.entity.Alumni;
import edu.alumni.repository.AlumniRepository;

@DataJpaTest
@Rollback(false)

class AlumnimanagmentsystemApplicationTests {

	
	@Autowired
	private AlumniRepository alumniRepository;
	
    //Testing agent	
	@Autowired
	private TestEntityManager entityManager;

	
	//Checks the method for finding Alumni by name
	@Test
	public void testCheckNewAlumni() {
		entityManager.persist(new Alumni("Swastika","9987773710","@gmail.com","2022","Mumbai"));
		List<Alumni> gotT = alumniRepository.findByNameContaining("Swastika");
		for (Alumni a : gotT) {
			assertThat(a.getName()).isEqualTo("Swastika");

		}

	}
	
	//Checks the method for finding Alumni by graduation year
	@Test
	public void testCheckByYear() {
		entityManager.persist(new Alumni("Swastika","9987773710","@gmail.com","2022","Mumbai"));
		List<Alumni> gotA = alumniRepository.findBygrdYearContaining("2022");
		for (Alumni a : gotA) {
			assertThat(a.getGrdYear()).isEqualTo("2022");

		}

	}
	
	//Checks the method for deleting Alumni by Id
	@Test
	public void testCheckDeleteById() {
		
		Alumni aNew = alumniRepository.save(new Alumni("Swastika","9877293710","@gmail.com","2022","Mumbai"));
		alumniRepository.deleteById(aNew.getId());
		assertFalse(alumniRepository.findById(aNew.getId()).isPresent());
		
	}

	//Checks the method for adding a new Alumni
	@Test
	public void testCreateAlumni() {
		Alumni aNew = alumniRepository.save(new Alumni("Swastika","8887293710","@gmail.com","2022","Mumbai"));
		Alumni tFetched = alumniRepository.findById(aNew.getId()).get();
		assertThat(tFetched.getId()).isGreaterThan(0);

	}

	//Checks the method for adding a new Alumni
	@Test
	public void testUpdateAlumni() {
		Alumni aNew = alumniRepository.save(new Alumni("Swastika","9877293710","@gmail.com","2022","Mumbai"));
		Alumni aFetched = alumniRepository.findById(aNew.getId()).get();
		aFetched.setName("Sanskar");
		Alumni aAgain = alumniRepository.save(aFetched);
		Alumni aFetchedAgain = alumniRepository.findById(aAgain.getId()).get();
	    assertThat(aFetchedAgain.getName()).isEqualTo("Sanskar");

	}

}
