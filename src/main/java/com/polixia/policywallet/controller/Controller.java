package com.polixia.policywallet.controller;


import com.polixia.policywallet.core.component.LoggerFactory;
import com.polixia.policywallet.model.Department;
import com.polixia.policywallet.model.DepartmentId;
import com.polixia.policywallet.model.Employee;
import com.polixia.policywallet.model.EmployeeId;
import com.polixia.policywallet.repository.DepartmentRepository;
import com.polixia.policywallet.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {


    @Bean
    private LoggerFactory.Logger logger() {
        return new LoggerFactory.Logger(this.getClass());
    }

    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    LoggerFactory.Logger logger;

    @Autowired
    EmployeeRepository employeeRepository;

    @RequestMapping("/employees/{id}")
    public Employee getEmployee() {
        EmployeeId employeeId = new EmployeeId();
        DepartmentId departmentId = new DepartmentId();
        departmentId.setLocation("Kalutara");
        departmentId.setName("RnD");
        employeeId.setDepartmentId(departmentId);
        employeeId.setName("Bhagya");
        Employee employee = employeeRepository.findByEmployeeId(employeeId);
        return employee;
    }

    @RequestMapping("/departments/{id}")
    public Department getDepartment() {
        DepartmentId departmentId = new DepartmentId();
        departmentId.setName("RnD");
        departmentId.setLocation("Kalutara");
        Department department = departmentRepository.findByDepartmentId(departmentId);
        return department;
    }

    @RequestMapping(value = "/employees", method = RequestMethod.POST)
    public Employee addEmployee(@RequestBody Employee employee) {
        Employee employee1 = employeeRepository.save(employee);
        return employee1;
    }


    @RequestMapping(value = "/departments", method = RequestMethod.POST)
    public Department addDepartment(@RequestBody Department department) {
        Department department1 = departmentRepository.save(department);
        return department1;
    }
}
