package com.gdms.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="reply_group_teacher")
public class ReplyGroupTeacher {
    @Id
    @GeneratedValue(generator = "UUID")
    private Integer id;

    private String tid;

    private Integer gid;

    public ReplyGroupTeacher(Integer id, String tid, Integer gid) {
        this.id = id;
        this.tid = tid;
        this.gid = gid;
    }

    public ReplyGroupTeacher() {
    }

    public Integer getId() {
        return id;
    }

    public String getTid() {
        return tid;
    }

    public Integer getGid() {
        return gid;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    @Override
    public String toString() {
        return "ReplyGroupTeacher{" +
                "id=" + id +
                ", tid='" + tid + '\'' +
                ", gid=" + gid +
                '}';
    }
}