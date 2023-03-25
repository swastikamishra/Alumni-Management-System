package edu.alumni.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.alumni.entity.Alumni;


public interface AlumniRepository extends JpaRepository <Alumni,Integer>{
	
	
	    // custom spring boot search methods

		List<Alumni> findByNameContaining(String name);

		List<Alumni> findBygrdYearContaining(String grdYear);

}
