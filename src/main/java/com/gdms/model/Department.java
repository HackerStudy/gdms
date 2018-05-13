package com.gdms.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="department")
public class Department {
    @Id
    @GeneratedValue(generator = "UUID")
    private Integer did;

    private String departmentName;

    public Department(Integer did, String departmentName) {
        this.did = did;
        this.departmentName = departmentName;
    }

    public Department() {
    }

    public Integer getDid() {
        return did;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "did=" + did +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}