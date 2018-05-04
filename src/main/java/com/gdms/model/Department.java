package com.gdms.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="department")
public class Department {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer did;

    private String departmentName;

    public Department(Integer did, String departmentName) {
        this.did = did;
        this.departmentName = departmentName;
    }

    public Integer getDid() {
        return did;
    }

    public String getDepartmentName() {
        return departmentName;
    }
}