package com.paypal.bfs.test.employeeserv.api.controller;

import com.paypal.bfs.test.employeeserv.api.model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


/**
 * Interface for employee resource operations.
 */
@RestController
public interface EmployeeResource {

    /**
     * Retrieves the {@link Employee} resource by id.
     *
     * @param id employee id.
     * @return {@link Employee} resource.
     */
    @RequestMapping("/v1/bfs/employees/{id}")
    public ResponseEntity<Employee> employeeGetById(@PathVariable("id") String id);


    /**
     * Creates new employee resource
     *
     * @param employee
     * @return
     */
    @RequestMapping(value = "/v1/bfs/employee", method = RequestMethod.POST)
    public ResponseEntity<Employee> addEmployee(@Validated @RequestBody Employee employee);

}
