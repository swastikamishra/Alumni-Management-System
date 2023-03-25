package edu.alumni.service;

import java.util.List;

import edu.alumni.dto.AlumniDTO;
import edu.alumni.entity.Alumni;


public interface AlumniService {
	
	//To get record of all the Alumni
	List<Alumni> getAllAlumni();
	
	//To add a new Alumni
	Alumni createAlumni(AlumniDTO alumniDTO);
	
	//To update an Alumni using Id
	Alumni updateAlumni(int id,AlumniDTO alumniDTO);
	
	//To display an Alumni using Id
	Alumni getAllAlumniById (int id);
	
	//To display an Alumni using its name
	List<Alumni> findByNameContaining(String name);
	
	//To display an Alumni using graduation year
	List<Alumni> findByGrdYearContaning(String grdYear);
	
	//To delete an Alumni by its Id
	String deleteAlumni (int id);

	

}
