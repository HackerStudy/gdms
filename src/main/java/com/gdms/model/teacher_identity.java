package com.gdms.model;

import org.springframework.stereotype.Component;

@Component
public class teacher_identity {
    private int id;
    private int teacher_id;
    private String tid;
    private int identity_id;

    public teacher_identity(int id, int teacher_id, String tid, int identity_id) {
        this.id = id;
        this.teacher_id = teacher_id;
        this.tid = tid;
        this.identity_id = identity_id;
    }

    public teacher_identity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public int getIdentity_id() {
        return identity_id;
    }

    public void setIdentity_id(int identity_id) {
        this.identity_id = identity_id;
    }

    @Override
    public String toString() {
        return "teacher_identity{" +
                "id=" + id +
                ", teacher_id=" + teacher_id +
                ", tid='" + tid + '\'' +
                ", identity_id=" + identity_id +
                '}';
    }
}
