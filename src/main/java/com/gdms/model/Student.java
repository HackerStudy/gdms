package com.gdms.model;

import org.springframework.stereotype.Component;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Component("student")
@Table(name="student")
public class Student {
    @Id
    @GeneratedValue(generator = "UUID")
    private int sid;
    private String name;
    private String password;
    private String sex;
    private String department;
    private String major;
    private String grade;
    private String sclass;
    private int phone;
    private String email;
    private String icon;
    private int adviserid;
    private int replygroupid;

    public Student(String name, String password, String sex, String department, String major, String grade, String sclass, int phone, String email, String icon, int adviserid, int replygroupid) {
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.department = department;
        this.major = major;
        this.grade = grade;
        this.sclass = sclass;
        this.phone = phone;
        this.email = email;
        this.icon = icon;
        this.adviserid = adviserid;
        this.replygroupid = replygroupid;
    }

    public Student() {
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getSclass() {
        return sclass;
    }

    public void setSclass(String sclass) {
        this.sclass = sclass;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getAdviserid() {
        return adviserid;
    }

    public void setAdviserid(int adviserid) {
        this.adviserid = adviserid;
    }

    public int getReplygroupid() {
        return replygroupid;
    }

    public void setReplygroupid(int replygroupid) {
        this.replygroupid = replygroupid;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", department='" + department + '\'' +
                ", major='" + major + '\'' +
                ", grade='" + grade + '\'' +
                ", sclass='" + sclass + '\'' +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                ", icon='" + icon + '\'' +
                ", adviserid=" + adviserid +
                ", replygroupid=" + replygroupid +
                '}';
    }
}
