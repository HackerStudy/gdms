package com.gdms.model;

import org.springframework.stereotype.Component;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Component("teacher")
@Table(name="teacher")
public class Teacher {
    @Id
    @GeneratedValue(generator = "UUID")
    private int tid;
    private String tname;
    private String password;
    private String sex;
    private String work_time;
    private String hdegree;
    private String thesis;
    private String position;
    private String icon;
    private String belong_department;
    private String belong_major;
    private String identity_id;

    public Teacher(int tid, String tname, String password, String sex, String work_time, String hdegree, String thesis, String position, String icon, String belong_department, String belong_major, String identity_id) {
        this.tid = tid;
        this.tname = tname;
        this.password = password;
        this.sex = sex;
        this.work_time = work_time;
        this.hdegree = hdegree;
        this.thesis = thesis;
        this.position = position;
        this.icon = icon;
        this.belong_department = belong_department;
        this.belong_major = belong_major;
        this.identity_id = identity_id;
    }

    public Teacher() {
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
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

    public String getWork_time() {
        return work_time;
    }

    public void setWork_time(String work_time) {
        this.work_time = work_time;
    }

    public String getHdegree() {
        return hdegree;
    }

    public void setHdegree(String hdegree) {
        this.hdegree = hdegree;
    }

    public String getThesis() {
        return thesis;
    }

    public void setThesis(String thesis) {
        this.thesis = thesis;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getBelong_department() {
        return belong_department;
    }

    public void setBelong_department(String belong_department) {
        this.belong_department = belong_department;
    }

    public String getBelong_major() {
        return belong_major;
    }

    public void setBelong_major(String belong_major) {
        this.belong_major = belong_major;
    }

    public String getIdentity_id() {
        return identity_id;
    }

    public void setIdentity_id(String identity_id) {
        this.identity_id = identity_id;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "tid=" + tid +
                ", tname='" + tname + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", work_time='" + work_time + '\'' +
                ", hdegree='" + hdegree + '\'' +
                ", thesis='" + thesis + '\'' +
                ", position='" + position + '\'' +
                ", icon='" + icon + '\'' +
                ", belong_department='" + belong_department + '\'' +
                ", belong_major='" + belong_major + '\'' +
                ", identity_id='" + identity_id + '\'' +
                '}';
    }
}
