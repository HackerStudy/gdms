package com.gdms.model;

import org.springframework.stereotype.Component;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Component("teacher")
public class Teacher {
    private int id;
    private String tid;
    private String tname;
    private String password;
    private int sex;
    private String work_time;
    private String hdegree;
    private String teaching_direction;
    private String position;
    private String icon;
    private int did;
    private int mid;
    private int identity_id;

    public Teacher(int id, String tid, String tname, String password, int sex, String work_time, String hdegree, String teaching_direction, String position, String icon, int did, int mid, int identity_id) {
        this.id = id;
        this.tid = tid;
        this.tname = tname;
        this.password = password;
        this.sex = sex;
        this.work_time = work_time;
        this.hdegree = hdegree;
        this.teaching_direction = teaching_direction;
        this.position = position;
        this.icon = icon;
        this.did = did;
        this.mid = mid;
        this.identity_id = identity_id;
    }

    public Teacher() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
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

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
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

    public String getTeaching_direction() {
        return teaching_direction;
    }

    public void setTeaching_direction(String teaching_direction) {
        this.teaching_direction = teaching_direction;
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

    public int getIdentity_id() {
        return identity_id;
    }

    public void setIdentity_id(int identity_id) {
        this.identity_id = identity_id;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", tid='" + tid + '\'' +
                ", tname='" + tname + '\'' +
                ", password='" + password + '\'' +
                ", sex=" + sex +
                ", work_time='" + work_time + '\'' +
                ", hdegree='" + hdegree + '\'' +
                ", teaching_direction='" + teaching_direction + '\'' +
                ", position='" + position + '\'' +
                ", icon='" + icon + '\'' +
                ", did=" + did +
                ", mid=" + mid +
                ", identity_id=" + identity_id +
                '}';
    }
}
