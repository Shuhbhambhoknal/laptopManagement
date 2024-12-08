package com.olm.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.olm.models.Services;

@Repository
public interface ServiceRepository extends JpaRepository<Services, Long> {

}
