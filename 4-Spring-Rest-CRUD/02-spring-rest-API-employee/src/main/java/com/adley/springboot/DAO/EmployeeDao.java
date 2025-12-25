package com.adley.springboot.DAO;

import com.adley.springboot.Entity.Employee;

import java.util.List;

public interface EmployeeDao {

   List<Employee> employeedetails();
   Employee findById(int id);
   Employee save(Employee employee);
   void DeleteId(int id);


}
