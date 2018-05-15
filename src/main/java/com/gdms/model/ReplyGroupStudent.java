package com.gdms.model;


import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="reply_group_student")
public class ReplyGroupStudent {
    @Id
    @GeneratedValue(generator = "UUID")
    private Integer id;

    private String sid;

    private Integer gid;

    public ReplyGroupStudent(Integer id, String sid, Integer gid) {
        this.id = id;
        this.sid = sid;
        this.gid = gid;
    }

    public ReplyGroupStudent() {
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

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    @Override
    public String toString() {
        return "ReplyGroupStudent{" +
                "id=" + id +
                ", sid='" + sid + '\'' +
                ", gid=" + gid +
                '}';
    }
}