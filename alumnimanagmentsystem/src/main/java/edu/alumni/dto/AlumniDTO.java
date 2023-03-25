package edu.alumni.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AlumniDTO {
	
	//Adding Validations
	
	@NotBlank(message = "Invalid name: Empty name")
	@NotNull(message = "Invalid name: Name is NULL")
	@Size(min = 3, max = 30, message = "Invalid Name: Must be of 3-25 characters")
	private String name;
	

	@NotNull(message = "Invalid Phone Number: number is NULL")
	@NotBlank(message = "Invalid Phone Number: Empty Number")
	@Pattern(regexp = "^\\d{10}$", message = "Invalid phone Number !")
	private String phone;
	
	@NotNull
	@Email(message = "Invalid email")
	private String email;
	
	@NotBlank(message = "Invalid name: Empty name")
	@NotNull(message = "Invalid name: Name is NULL")
	private String grdYear;
	
	@NotBlank(message = "Invalid address: Empty address")
	@NotNull(message = "Invalid address: Address is NULL")
	@Size(min = 10, max = 50, message = "Invalid address: Must be of 10-50 characters")
	private String address;
	

}
