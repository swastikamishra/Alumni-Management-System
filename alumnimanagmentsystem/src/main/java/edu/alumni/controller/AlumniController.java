package edu.alumni.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.alumni.dto.AlumniDTO;
import edu.alumni.entity.Alumni;
import edu.alumni.service.AlumniService;


@RestController
@RequestMapping("/api")
public class AlumniController {
	
	//Constructor Injection
		@Autowired
		private AlumniService alumniService;
		
		
		//Adds a new Alumni
		@PostMapping("/students")
		public ResponseEntity<Alumni> createAlumni(@RequestBody @Valid AlumniDTO a) 
		{
			
			     Alumni a1 = alumniService.createAlumni(a);
				 return new ResponseEntity<>(a1, HttpStatus.CREATED);
			
		}
		

		//Updates an Alumni based on their Id
		@PutMapping("/students/{id}")
		public ResponseEntity<Alumni> updateAlumni(@PathVariable("id") int id, @RequestBody AlumniDTO alumniDTO)
		{
			
			    alumniService.updateAlumni(id, alumniDTO);
				return ResponseEntity.ok().body(alumniService.updateAlumni(id, alumniDTO));
			
		}
		

		//Displays an Alumni based on their name
		@GetMapping("/studentsname")
		public ResponseEntity<List<Alumni>> getAlumniByName(@RequestParam(required = false) String name)
		 {
			
				List<Alumni> alumni = alumniService.findByNameContaining(name);
				return ResponseEntity.ok(alumni);
				
		 }

		//Displays an Alumni based on their graduation year
		@GetMapping("/studentsyear")
		public ResponseEntity<List<Alumni>> getAlumniByGraduationYear(@RequestParam(required = false) String grdYear)
		{
					
				List<Alumni> alumni = alumniService.findByGrdYearContaning(grdYear);
				return ResponseEntity.ok(alumni);
						
		}
		
		//Displays an Alumni based on their Id
		@GetMapping("/students/{id}")
		public ResponseEntity<Alumni> getAllAlumniById(@PathVariable int id) 
		{
			
			return ResponseEntity.ok().body(alumniService.getAllAlumniById(id));
		
		}
		

		//Deletes an Alumni based on their Id
		@DeleteMapping("/students/{id}")
		public ResponseEntity<Alumni> deleteAlumni(@PathVariable int id)
		{
			alumniService.deleteAlumni(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		}
		
		//Lists all the Alumni
		@GetMapping("/students")
		public ResponseEntity <List<Alumni>>fetchAllAlumnis() 
		{
			
			List<Alumni> alumni = alumniService.getAllAlumni();
			return ResponseEntity.ok(alumni);
		
		}

}
