package com.gdms.vo;

public class ReplyStudentVo {
    private Integer id;

    private String sid;

    private String name;

    private String sex;

    private String department;

    private String major;

    private String grade;

    private String sclass;

    private String phone;

    private String email;

    private String adviserTname;

    public ReplyStudentVo(Integer id, String sid, String name, String sex, String department, String major, String grade, String sclass, String phone, String email, String adviserTname) {
        this.id = id;
        this.sid = sid;
        this.name = name;
        this.sex = sex;
        this.department = department;
        this.major = major;
        this.grade = grade;
        this.sclass = sclass;
        this.phone = phone;
        this.email = email;
        this.adviserTname = adviserTname;
    }

    public ReplyStudentVo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdviserTname() {
        return adviserTname;
    }

    public void setAdviserTname(String adviserTname) {
        this.adviserTname = adviserTname;
    }

    @Override
    public String toString() {
        return "ReplyStudentVo{" +
                "id=" + id +
                ", sid='" + sid + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", department='" + department + '\'' +
                ", major='" + major + '\'' +
                ", grade='" + grade + '\'' +
                ", sclass='" + sclass + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", adviserTname='" + adviserTname + '\'' +
                '}';
    }
}
