/*
 * @Author SWASTIKA
 */
package edu.alumni.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "alumnitable")
public class Alumni {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "sId")
	private Integer id;
	@Column(name = "sName", length = 30)
	private String name;
	@Column(name = "sPhoneNo", length = 60)
	private String phone;
	@Column(name = "sEmail", length = 30)
	private String email;
	@Column(name = "sGraduationYear",length = 5)
	private String grdYear;
	@Column(name = "sAddress",length = 30)
	private String address;
	
	
	public Alumni(String name, String phone, String email, String grdYear, String address) {
		super();
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.grdYear = grdYear;
		this.address = address;
	}
	
	}
	


