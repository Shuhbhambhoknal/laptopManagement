package com.olm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.olm.models.Laptop;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long>{

	

	@Query("SELECT d FROM Laptop d JOIN d.employee e WHERE e.employeeId = :employeeId")
    Laptop findByEmployeeId(@Param("employeeId") Long employeeId);

}
