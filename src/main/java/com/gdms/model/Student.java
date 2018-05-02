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
    private int id;
    private String sid;
    private String name;
    private String password;
    private int sex;
    private int did;
    private int mid;
    private String grade;
    private String sclass;
    private String phone;
    private String email;
    private String icon;
    private int adviserid;
    private int replygroupid;

    public Student(String sid, String name, String password, int sex, int did, int mid, String grade, String sclass, String phone, String email, String icon, int adviserid, int replygroupid) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
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
