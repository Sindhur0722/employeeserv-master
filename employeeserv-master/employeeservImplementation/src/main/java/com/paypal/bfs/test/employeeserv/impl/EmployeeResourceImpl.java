package com.paypal.bfs.test.employeeserv.impl;

import com.paypal.bfs.test.employeeserv.api.controller.EmployeeResource;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.api.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * Implementation class for employee resource.
 */
@RestController
public class EmployeeResourceImpl implements EmployeeResource {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public ResponseEntity<Employee> employeeGetById(String id) {
        ResponseEntity<Employee> result = null;
        try{
            result = new ResponseEntity<>(employeeRepository.findById(Long.parseLong(id)).get(), HttpStatus.OK);
        } catch (Exception e) {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return  result;
    }

    /**
     * @param employee
     * @return
     */
    @Override
    public ResponseEntity<Employee> addEmployee(Employee employee) {
        // TODO: check if exist 
        Employee result = employeeRepository.findByFirstNameAndLastName(employee.getFirstName(), employee.getLastName());
        if (result != null) {
            return new ResponseEntity<>(HttpStatus.FOUND);
        }
        return new ResponseEntity<>(employeeRepository.save(employee), HttpStatus.CREATED);
    }
}
