package com.gdms.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="student")
public class Student {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String sid;

    private String name;

    private String password;

    private Integer sex;

    private Integer did;

    private Integer mid;

    private String grade;

    private String sclass;

    private String phone;

    private String email;

    private String icon;

    private Integer adviserid;

    private Integer replygroupid;

    public Student(Integer id, String sid, String name, String password, Integer sex, Integer did, Integer mid, String grade, String sclass, String phone, String email, String icon, Integer adviserid, Integer replygroupid) {
        this.id = id;
        this.sid = sid;
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.did = did;
        this.mid = mid;
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

    public Integer getId() {
        return id;
    }

    public String getSid() {
        return sid;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public Integer getSex() {
        return sex;
    }

    public Integer getDid() {
        return did;
    }

    public Integer getMid() {
        return mid;
    }

    public String getGrade() {
        return grade;
    }

    public String getSclass() {
        return sclass;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getIcon() {
        return icon;
    }

    public Integer getAdviserid() {
        return adviserid;
    }

    public Integer getReplygroupid() {
        return replygroupid;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setSclass(String sclass) {
        this.sclass = sclass;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setAdviserid(Integer adviserid) {
        this.adviserid = adviserid;
    }

    public void setReplygroupid(Integer replygroupid) {
        this.replygroupid = replygroupid;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", sid='" + sid + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", sex=" + sex +
                ", did=" + did +
                ", mid=" + mid +
                ", grade='" + grade + '\'' +
                ", sclass='" + sclass + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", icon='" + icon + '\'' +
                ", adviserid=" + adviserid +
                ", replygroupid=" + replygroupid +
                '}';
    }
}