package edu.alumni.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.alumni.dto.AlumniDTO;
import edu.alumni.entity.Alumni;
import edu.alumni.exception.UserNotFoundException;
import edu.alumni.repository.AlumniRepository;
import edu.alumni.service.AlumniService;

@Service
public class AlumniServiceImpl implements AlumniService{
	
	//Constructor Injection
	@Autowired
    private AlumniRepository alumniRepository;


	//To display all the Alumni
	@Override
	public List<Alumni> getAllAlumni() {

		return alumniRepository.findAll();
	}

	
	//To add an Alumni
	@Override
	public Alumni createAlumni(AlumniDTO alumniDTO) {
		
	Alumni alumni = Alumni.builder().name(alumniDTO.getName()).email(alumniDTO.getEmail()).phone(alumniDTO.getPhone())
			.grdYear(alumniDTO.getGrdYear()).address(alumniDTO.getAddress()).build();
	
	return alumniRepository.save(alumni);
		
	}

	//To update an Alumni's details by their Id
	@Override
	public Alumni updateAlumni(int id, AlumniDTO alumniDTO) throws UserNotFoundException
    {
	Optional <Alumni> adata = alumniRepository.findById(id);
	if (adata.isPresent())
	{
		Alumni _alumni = alumniRepository.findById(id).get();
		_alumni.setName(alumniDTO.getName());
		_alumni.setPhone(alumniDTO.getPhone());
		_alumni.setEmail(alumniDTO.getEmail());
		_alumni.setGrdYear(alumniDTO.getGrdYear());
		_alumni.setAddress(alumniDTO.getAddress());
	
	return alumniRepository.save(_alumni);
	}
	else throw new UserNotFoundException("No user bearing id "+id+" can be found"); 
}

	//To find an Alumni by their Id
	@Override
	public Alumni getAllAlumniById(int id) 
	{
		return alumniRepository.findById(id).orElseThrow(() -> new UserNotFoundException("No user bearing id "+id+" can be found"));
	}

	//To find an Alumni by their name
	@Override
	public List<Alumni> findByNameContaining(String name) throws UserNotFoundException
	{
		
		if(alumniRepository.findByNameContaining(name).isEmpty())
		
			throw new UserNotFoundException("No student bearing name "+name+" can be found");
		
		else
			
		return alumniRepository.findByNameContaining(name);
		
	}

	//To find an Alumni by their graduation year
	@Override
	public List<Alumni> findByGrdYearContaning (String grdYear) 
	{
		if(alumniRepository.findBygrdYearContaining(grdYear).isEmpty() )
			
		throw new UserNotFoundException("No student with graduation year "+grdYear+" can be found");
		
		else
			
		return alumniRepository.findBygrdYearContaining(grdYear);
	}

	//To delete an Alumni by their Id
	@Override
	public String deleteAlumni(int id) 
	{
		
		alumniRepository.deleteById(id);
		return "Student bearing Id "+ id +"has been deleted sucessfully!";
	}

}
