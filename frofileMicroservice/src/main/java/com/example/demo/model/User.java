package com.example.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
	private Integer id;
    
    @Size(min = 2,max=50,message = "fist name must be bet 2 to 50 char")
	private String firstName;
    @Size(min = 2,max=50,message = "last name must be bet 2 to 50 char")
	private String lastName;
    
    @Column(unique=true )
    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",message="Please provid valid Email")
	private String email;
    
    @Size(min=10,max=10,message="mobile number should be 10 charecter")
    @Pattern(regexp ="(0/91)?[7-9][0-9]{9}",message="Enter valid Mobile Number")
	private String phoneNumber;
    
	@OneToMany(cascade = CascadeType.ALL)
	private List<Address> address;
	
}
