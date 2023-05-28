package dto;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Entity
@Data
public class Customer
{
	@Id
	@GeneratedValue(generator = "a")
	@SequenceGenerator(name = "a",sequenceName = "a",initialValue = 121456,allocationSize = 1)
	int id;
	String fname;
	String lname;
	long mobile;
	String email;
	String gender;
	String pass;
	Date dob;
}
