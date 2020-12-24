package com.pace.wisdom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pace.wisdom.model.EmployeeEntity;


@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {

	EmployeeEntity findByeId(int eId);

}
