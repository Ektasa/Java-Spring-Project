package com.adley.springboot.Service;

import com.adley.springboot.DAO.EmployeeRepository;
import com.adley.springboot.Entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepo;


    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> result = employeeRepo.findById(id);

        Employee theEmployee = null;

        if (result.isPresent()) {
            theEmployee = result.get();
        } else {
            // we didn't find the employee
            throw new RuntimeException("Did not find employee id - " + id);
        }
            return theEmployee;
        }

    @Transactional
    @Override
    public Employee save(Employee employee) {
       Employee emp = employeeRepo.save(employee);
       return emp;
    }
    @Transactional
    @Override
    public void DeleteId(int id) {
        employeeRepo.deleteById(id);
    }


}
