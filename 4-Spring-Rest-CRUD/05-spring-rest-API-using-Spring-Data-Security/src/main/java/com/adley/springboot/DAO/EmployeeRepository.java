package com.adley.springboot.DAO;

import com.adley.springboot.Entity.Employee;

import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
