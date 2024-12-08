package com.olm.models;


import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId; 


	private String firstName;

    private String lastName;

    private String emailId;

    private String contactNumber;

    private LocalDate dateOfBirth;

    private LocalDate dateOfJoining;

    private String designation;
    
    @ManyToOne
    @JoinColumn(name = "departmentId")
    private Department department;
    

    @OneToOne()
    @JoinColumn(name = "laptopId")
    private Laptop laptop;
    
    @OneToMany(mappedBy = "employee" , cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Services> serviceList;

    // Default Constructor
    public Employee() {}

    // Getters and Setters (if not using Lombok)
    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public List<Services> getServiceList() {
  		return serviceList;
  	}

  	public void setServiceList(List<Services> serviceList) {
  		this.serviceList = serviceList;
  	}

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(LocalDate dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Laptop getLaptop() {
		return laptop;
	}

	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}

//	public List<Service> getServiceList() {
//		return serviceList;
//	}
//
//	public void setServiceList(List<Service> serviceList) {
//		this.serviceList = serviceList;
//	}
    
    
}
