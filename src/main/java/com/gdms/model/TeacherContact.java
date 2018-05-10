package com.gdms.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="teacher_contact")
public class TeacherContact {
    @Id
    @GeneratedValue(generator = "UUID")
    private Integer id;

    private String tid;

    private String email;

    private String phone;

    public TeacherContact(Integer id, String tid, String email, String phone) {
        this.id = id;
        this.tid = tid;
        this.email = email;
        this.phone = phone;
    }

    public TeacherContact() {
    }

    public Integer getId() {
        return id;
    }

    public String getTid() {
        return tid;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "TeacherContact{" +
                "id=" + id +
                ", tid='" + tid + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}