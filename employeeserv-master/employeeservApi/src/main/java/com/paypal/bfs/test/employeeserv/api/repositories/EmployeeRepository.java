package com.paypal.bfs.test.employeeserv.api.repositories;

import com.paypal.bfs.test.employeeserv.api.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    Employee findByFirstNameAndLastName(String firstName, String lastName);
}
