package com.gdms.vo;

public class TeacherInfoVo {
    private Integer id;

    private String tid;

    private String tname;

    private String sex;

    private String workTime;

    private String hdegree;

    private String teachingDirection;

    private String position;

    private String icon;

    private String department;

    private String major;

    private String identity;

    private String phone;

    private String email;

    public TeacherInfoVo(Integer id, String tid, String tname, String sex, String workTime, String hdegree, String teachingDirection, String position, String icon, String department, String major, String identity, String phone, String email) {
        this.id = id;
        this.tid = tid;
        this.tname = tname;
        this.sex = sex;
        this.workTime = workTime;
        this.hdegree = hdegree;
        this.teachingDirection = teachingDirection;
        this.position = position;
        this.icon = icon;
        this.department = department;
        this.major = major;
        this.identity = identity;
        this.phone = phone;
        this.email = email;
    }

    public TeacherInfoVo() {
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

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    public String getHdegree() {
        return hdegree;
    }

    public void setHdegree(String hdegree) {
        this.hdegree = hdegree;
    }

    public String getTeachingDirection() {
        return teachingDirection;
    }

    public void setTeachingDirection(String teachingDirection) {
        this.teachingDirection = teachingDirection;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
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
        return "TeacherInfoVo{" +
                "id=" + id +
                ", tid='" + tid + '\'' +
                ", tname='" + tname + '\'' +
                ", sex='" + sex + '\'' +
                ", workTime='" + workTime + '\'' +
                ", hdegree='" + hdegree + '\'' +
                ", teachingDirection='" + teachingDirection + '\'' +
                ", position='" + position + '\'' +
                ", icon='" + icon + '\'' +
                ", department='" + department + '\'' +
                ", major='" + major + '\'' +
                ", identity='" + identity + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
