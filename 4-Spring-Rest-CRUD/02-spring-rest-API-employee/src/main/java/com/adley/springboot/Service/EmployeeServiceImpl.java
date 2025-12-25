package com.adley.springboot.Service;

import com.adley.springboot.DAO.EmployeeDaoImpl;
import com.adley.springboot.Entity.Employee;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDaoImpl employeeDao;
    @Autowired
    public EmployeeServiceImpl(EmployeeDaoImpl employeeDao) {
        this.employeeDao = employeeDao;
    }
    @Override
    public List<Employee> getEmployees() {
        return employeeDao.employeedetails();
    }

    @Override
    public Employee findById(int id) {
        return employeeDao.findById(id);
    }
    @Transactional
    @Override
    public Employee save(Employee employee) {
       Employee emp = employeeDao.save(employee);
       return emp;
    }
    @Transactional
    @Override
    public void DeleteId(int id) {
        employeeDao.DeleteId(id);
    }


}
