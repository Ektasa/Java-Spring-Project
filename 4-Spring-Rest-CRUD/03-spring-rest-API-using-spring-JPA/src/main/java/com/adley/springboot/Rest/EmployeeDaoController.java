package com.adley.springboot.Rest;

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
    private EmployeeServiceImpl employeeService;

    private ObjectMapper objectMapper;

    @Autowired
    public EmployeeDaoController(EmployeeServiceImpl theEmployeeService, ObjectMapper theObjectMapper) {
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

    @PatchMapping("/employees/{employeeId}")
    public Employee patchEmployee(@PathVariable int employeeId,
                                  @RequestBody Map<String, Object> patchPayload) {

        Employee employee=employeeService.findById(employeeId);
        if(employee == null) {
            throw new RuntimeException("employee not found");
        }
        if (patchPayload.containsKey("id")) {
            throw new RuntimeException("Employee id not allowed in request body - " + employeeId);
        }

        Employee patchedEmployee = apply(patchPayload, employee);

        Employee dbEmployee = employeeService.save(patchedEmployee);

        return dbEmployee;

    }
    private Employee apply(Map<String, Object> patchPayload, Employee tempEmployee) {

        // Convert employee object to a JSON object node
        ObjectNode employeeNode = objectMapper.convertValue(tempEmployee, ObjectNode.class);

        // Convert the patchPayload map to a JSON object node
        ObjectNode patchNode = objectMapper.convertValue(patchPayload, ObjectNode.class);

        // Merge the patch updates into the employee node
        employeeNode.setAll(patchNode);

        return objectMapper.convertValue(employeeNode, Employee.class);
    }

    @DeleteMapping("/employee/{employeeid}")
    public String deleteEmployee(@PathVariable("employeeid") int employeeid) {
        Employee employee=employeeService.findById(employeeid);
        if(employee == null) {
            throw new RuntimeException("employee not found");
        }


        employeeService.DeleteId(employeeid);
        return "Employee deleted" + employeeid;


    }


}
