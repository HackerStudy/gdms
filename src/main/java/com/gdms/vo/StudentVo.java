package com.gdms.vo;

public class StudentVo {
    private Integer id;

    private String sid;

    private String name;

    private Integer sex;

    private Integer did;

    private Integer mid;

    private String grade;

    private String sclass;

    private String phone;

    private String email;

    public StudentVo(Integer id, String sid, String name, Integer sex, Integer did, Integer mid, String grade, String sclass, String phone, String email) {
        this.id = id;
        this.sid = sid;
        this.name = name;
        this.sex = sex;
        this.did = did;
        this.mid = mid;
        this.grade = grade;
        this.sclass = sclass;
        this.phone = phone;
        this.email = email;
    }

    public StudentVo() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getSclass() {
        return sclass;
    }

    public void setSclass(String sclass) {
        this.sclass = sclass;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "StudentVo{" +
                "id=" + id +
                ", sid='" + sid + '\'' +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", did=" + did +
                ", mid=" + mid +
                ", grade='" + grade + '\'' +
                ", sclass='" + sclass + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
