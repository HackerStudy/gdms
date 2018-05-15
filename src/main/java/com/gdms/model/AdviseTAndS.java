package com.gdms.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="advise_teacherandstudent")
public class AdviseTAndS {
    @Id
    @GeneratedValue(generator = "UUID")
    private Integer id;

    private String tid;

    private String sid;

    public AdviseTAndS(Integer id,String tid, String sid) {
        this.id=id;
        this.tid = tid;
        this.sid = sid;
    }

    public AdviseTAndS() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    @Override
    public String toString() {
        return "AdviseTAndS{" +
                "id=" + id +
                ", tid='" + tid + '\'' +
                ", sid='" + sid + '\'' +
                '}';
    }
}