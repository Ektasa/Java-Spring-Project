package com.adley.springboot.Rest;

import com.adley.springboot.DAO.EmployeeDaoImpl;
import com.adley.springboot.Entity.Employee;
import com.adley.springboot.Service.EmployeeService;
import com.adley.springboot.Service.EmployeeServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeDaoController  {
    private EmployeeService employeeService;

    private ObjectMapper objectMapper;

    @Autowired
    public EmployeeDaoController(EmployeeService theEmployeeService, ObjectMapper theObjectMapper) {
        employeeService = theEmployeeService;
        objectMapper = theObjectMapper;
    }

//    public EmployeeDaoController(EmployeeServiceImpl employeeService) {
//        this.employeeService = employeeService;
//    }
// add employee post
    @PostMapping("/employee")
    public Employee AddEmployees(@RequestBody Employee employee) {
     employee.setId(0);
       Employee dbemployee= employeeService.save(employee);
    return dbemployee;
    }
    //update employee by put
    @PutMapping("/employee")
    public Employee updateEmployees(@RequestBody Employee employee) {

        Employee dbemployee= employeeService.save(employee);
        return dbemployee;
    }
    //delete by id
    @DeleteMapping("/employee")
    public void DeleteEmployees(@RequestBody int id) {

       employeeService.DeleteId(id);

    }
    @GetMapping("/employee/{employeeid}")
    public Employee getEmployeeByID(@PathVariable("employeeid") int employeeid) {
        Employee employee=employeeService.findById(employeeid);
        return employee;
    }
    @GetMapping("/employee")
    public List<Employee> GetEmployees() {

        List<Employee> employeelist= employeeService.getEmployees();
        return employeelist;
    }


//@PatchMapping("/employee/{employeeid}")
//public Employee updateEmployees(@PathVariable("employeeid") int employeeid,@RequestBody Map<String, Object> patchpayload)
//{
//    Employee tempemployee=employeeService.findById(employeeid);
//    if(tempemployee==null)
//    {
//        throw new RuntimeException("employee not found "+ employeeid);
//    }
//
//    // if request body contains id
//    if(patchpayload.containsKey(employeeid))
//    {
//        throw new RuntimeException("employee unable to get request"+ employeeid);
//    }
//    Employee patchemployee=apply(patchpayload,tempemployee);
//    Employee dbemployee=employeeService.save(patchemployee);
//    return dbemployee;
//}
//  private Employee apply(Map<String, Object> patchpayload, Employee tempemployee) {
//
//      ObjectNode payload= ObjectMapper.convertValue(patchpayload, ObjectNode.class);
//      ObjectNode employeeNode=ObjectMapper.convertValue(tempemployee,ObjectNode.class);
//       employeeNode.setAll(payload);
//       return ObjectMapper.convertValue(employeeNode,Employee.class);
//
//
//  }
}
