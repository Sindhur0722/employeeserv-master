package com.paypal.bfs.test.employeeserv.api.controller;

import com.paypal.bfs.test.employeeserv.api.model.Address;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.sql.Date;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc(addFilters = false)
@ContextConfiguration(classes = EmployeeResource.class)
public class EmployeeResourceTest {

    @InjectMocks
    EmployeeResource employeeResource;

    @InjectMocks
    EmployeeResource employeeResourceimpl;

    @Autowired
    private MockMvc mockMvc;


    //@Before
    public void testAddEmployee() {
        Employee employee = new Employee();
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
    public void employeeGetById() throws Exception {
        RequestBuilder requestBuilder =
                MockMvcRequestBuilders.get("/v1/bfs/employees/1").accept(MediaType.APPLICATION_JSON);

        this.mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }
}
