package com.adley.springboot.Service;

import com.adley.springboot.Entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> getEmployees();

    Employee findById(int id);

    Employee save(Employee employee);

    void DeleteId(int id);

}
