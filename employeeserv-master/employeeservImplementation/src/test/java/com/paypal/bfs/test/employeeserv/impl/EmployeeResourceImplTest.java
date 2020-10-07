package com.paypal.bfs.test.employeeserv.impl;

import com.paypal.bfs.test.employeeserv.api.model.Address;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.api.repositories.EmployeeRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;
import java.sql.Date;
import java.util.Optional;

public class EmployeeResourceImplTest {

    @InjectMocks
    private EmployeeResourceImpl employeeResource;

    @Mock
    EmployeeRepository employeeRepository;

    public Employee employee;

    @Before
    public void testAddEmployee() {
        MockitoAnnotations.initMocks(this);
        employee = new Employee();
        employee.setEmployeeId(Long.valueOf(1));
        employee.setFirstName("Sindhu");
        employee.setLastName("ailneni");
        employee.setDateOfBirth(Date.valueOf("1990-07-22"));
        Address address = new Address();
        address.setAddressId(Long.valueOf(1));
        address.setLine1("6100 spring creek ln");
        address.setLine1("Apt#1");
        address.setCity("Ofallon");
        address.setState("MO");
        address.setCountry("United States");
        address.setZipCode(63368);
        employee.setAddress(address);
    }

    @Test
    public void employeeGetByIdTest() {

        Mockito.doReturn(Optional.of(employee)).when(employeeRepository).findById(Long.valueOf("1"));
        ResponseEntity<Employee>  result = employeeResource.employeeGetById("1");


        Assert.assertTrue(result != null);
    }

    @Test
    public void addEmployeeTest() {
        //Mockito.doReturn(employee).when(employeeRepository).findByFirstNameAndLastName("Sindhu","ailneni");
        Mockito.doReturn(employee).when(employeeRepository).save(Mockito.any(Employee.class));
        ResponseEntity<Employee> result  = employeeResource.addEmployee(employee);

        Assert.assertTrue(result != null);

    }

    @Test
    public void addEmployeeCheckExistTest() {
        Mockito.doReturn(employee).when(employeeRepository).findByFirstNameAndLastName("Sindhu","ailneni");
        ResponseEntity<Employee> result  = null;
        boolean employeeExist = false;
        try {
            result  = employeeResource.addEmployee(employee);
        } catch (ResponseStatusException e){
            employeeExist = true;
        }
        Assert.assertTrue(employeeExist);

    }
}
