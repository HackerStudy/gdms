package com.gdms.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="advise_teacher")
public class AdviseTeacher {
    @Id
    @GeneratedValue(generator = "UUID")
    private Integer id;

    private String tid;

    private Integer haveNumber;

    private Integer limitNumber;

    public AdviseTeacher(String tid, Integer haveNumber, Integer limitNumber) {
        this.tid = tid;
        this.haveNumber = haveNumber;
        this.limitNumber = limitNumber;
    }

    public AdviseTeacher() {
    }

    public Integer getId() {
        return id;
    }

    public String getTid() {
        return tid;
    }

    public Integer getHaveNumber() {
        return haveNumber;
    }

    public Integer getLimitNumber() {
        return limitNumber;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public void setHaveNumber(Integer haveNumber) {
        this.haveNumber = haveNumber;
    }

    public void setLimitNumber(Integer limitNumber) {
        this.limitNumber = limitNumber;
    }

    @Override
    public String toString() {
        return "AdviseTeacher{" +
                "id=" + id +
                ", tid='" + tid + '\'' +
                ", haveNumber=" + haveNumber +
                ", limitNumber=" + limitNumber +
                '}';
    }
}