package com.adley.springboot.DAO;

import com.adley.springboot.Entity.Employee;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    private EntityManager entityManager;
    @Autowired
    public EmployeeDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<Employee> employeedetails() {
        List<Employee> employeedetail = new ArrayList<>();
        employeedetail=entityManager.createQuery("from Employee e", Employee.class).getResultList();
        return employeedetail;
    }

    @Override
    public Employee findById(int id) {
       Employee employeeId = entityManager.find(Employee.class, id);
        return employeeId;
    }

    @Override
    public Employee save(Employee employee) {
        Employee dbemployee =entityManager.merge(employee);
        return dbemployee;
    }

    @Override
    public void DeleteId(int id) {
       Employee employee= entityManager.find(Employee.class, id);
       entityManager.remove(employee);

    }
}
