package com.polixia.policywallet.repository;

import com.polixia.policywallet.model.Employee;
import com.polixia.policywallet.model.EmployeeId;
import org.springframework.data.repository.Repository;

public interface EmployeeRepository extends Repository<Employee, EmployeeId> {


    Employee findByEmployeeId(EmployeeId employeeId);

    Employee save(Employee employee);
}
