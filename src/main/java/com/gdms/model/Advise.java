package com.gdms.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="advise_apply")
public class Advise {
    @Id
    @GeneratedValue(generator = "UUID")
    private Integer id;

    private String tid;

    private String sid;

    private Integer pass;

    public Advise(Integer id, String tid, String sid, Integer pass) {
        this.id = id;
        this.tid = tid;
        this.sid = sid;
        this.pass = pass;
    }

    public Advise() {
    }

    public Integer getId() {
        return id;
    }

    public String getTid() {
        return tid;
    }

    public String getSid() {
        return sid;
    }

    public Integer getPass() {
        return pass;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public void setPass(Integer pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "Advise{" +
                "id=" + id +
                ", tid='" + tid + '\'' +
                ", sid='" + sid + '\'' +
                ", pass=" + pass +
                '}';
    }
}