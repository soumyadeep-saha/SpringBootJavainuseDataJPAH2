package com.soumyadeep.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soumyadeep.springboot.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
