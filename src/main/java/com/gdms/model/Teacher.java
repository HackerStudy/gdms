package com.gdms.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String tid;

    private String tname;

    private String password;

    private Integer sex;

    private String workTime;

    private String hdegree;

    private String teachingDirection;

    private String position;

    private String icon;

    private Integer did;

    private Integer mid;

    private Integer identityId;

    public Teacher(Integer id, String tid, String tname, String password, Integer sex, String workTime, String hdegree, String teachingDirection, String position, String icon, Integer did, Integer mid, Integer identityId) {
        this.id = id;
        this.tid = tid;
        this.tname = tname;
        this.password = password;
        this.sex = sex;
        this.workTime = workTime;
        this.hdegree = hdegree;
        this.teachingDirection = teachingDirection;
        this.position = position;
        this.icon = icon;
        this.did = did;
        this.mid = mid;
        this.identityId = identityId;
    }

    public Teacher() {
    }

    public Integer getId() {
        return id;
    }

    public String getTid() {
        return tid;
    }

    public String getTname() {
        return tname;
    }

    public String getPassword() {
        return password;
    }

    public Integer getSex() {
        return sex;
    }

    public String getWorkTime() {
        return workTime;
    }

    public String getHdegree() {
        return hdegree;
    }

    public String getTeachingDirection() {
        return teachingDirection;
    }

    public String getPosition() {
        return position;
    }

    public String getIcon() {
        return icon;
    }

    public Integer getDid() {
        return did;
    }

    public Integer getMid() {
        return mid;
    }

    public Integer getIdentityId() {
        return identityId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    public void setHdegree(String hdegree) {
        this.hdegree = hdegree;
    }

    public void setTeachingDirection(String teachingDirection) {
        this.teachingDirection = teachingDirection;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public void setIdentityId(Integer identityId) {
        this.identityId = identityId;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", tid='" + tid + '\'' +
                ", tname='" + tname + '\'' +
                ", password='" + password + '\'' +
                ", sex=" + sex +
                ", workTime='" + workTime + '\'' +
                ", hdegree='" + hdegree + '\'' +
                ", teachingDirection='" + teachingDirection + '\'' +
                ", position='" + position + '\'' +
                ", icon='" + icon + '\'' +
                ", did=" + did +
                ", mid=" + mid +
                ", identityId=" + identityId +
                '}';
    }
}