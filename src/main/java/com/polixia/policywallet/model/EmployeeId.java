package com.polixia.policywallet.model;

import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;

@Data
public class EmployeeId implements Serializable {

    DepartmentId departmentId;
    @Column(name = "Name")
    private String name;

}
