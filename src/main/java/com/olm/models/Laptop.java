package com.olm.models;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

@Data
@Entity
@Table(name="laptop")
public class Laptop {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long laptopId; 

    private String brand;

    private String model;

    private String specification;

    private LocalDate purchaseDate;

    private double price;

    private String laptopStatus;

    private LocalDate issueDate;
    
    @ManyToOne()  // Add CascadeType.PERSIST
    @JoinColumn(name = "dealerId", nullable = false)
    private Dealer dealer;
    
    @OneToOne(mappedBy = "laptop")
    @JsonBackReference
    private Employee employee;
    
//    @OneToMany(mappedBy = "laptop")
//    @JsonIgnore
//    private List<Services> services;
    
    @Transient private boolean deleted;

    // Default Constructor
    public Laptop() {
    	this.deleted=false;
    }

    // Getters and Setters (optional if using Lombok)
    public Long getLaptopId() {
        return laptopId;
    }

    public void setLaptopId(Long laptopId) {
        this.laptopId = laptopId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getLaptopStatus() {
        return laptopStatus;
    }

    public void setLaptopStatus(String laptopStatus) {
        this.laptopStatus = laptopStatus;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public Dealer getDealer() {
		return dealer;
	}

	public void setDealer(Dealer dealer) {
		this.dealer = dealer;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
    
    

}
