package com.gdms.vo;

public class AdviseTeacherVo {
    private Integer id;

    private String tid;

    private String tname;

    private String sex;

    private String workTime;

    private String hdegree;

    private String teachingDirection;

    private String position;

    private String department;

    private String major;

    private String phone;

    private String email;

    private Integer haveNumber;

    private Integer limitNumber;

    public AdviseTeacherVo(Integer id, String tid, String tname, String sex, String workTime, String hdegree, String teachingDirection, String position, String department, String major, String phone, String email, Integer haveNumber, Integer limitNumber) {
        this.id = id;
        this.tid = tid;
        this.tname = tname;
        this.sex = sex;
        this.workTime = workTime;
        this.hdegree = hdegree;
        this.teachingDirection = teachingDirection;
        this.position = position;
        this.department = department;
        this.major = major;
        this.phone = phone;
        this.email = email;
        this.haveNumber = haveNumber;
        this.limitNumber = limitNumber;
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

    public Integer getHaveNumber() {
        return haveNumber;
    }

    public void setHaveNumber(Integer haveNumber) {
        this.haveNumber = haveNumber;
    }

    public Integer getLimitNumber() {
        return limitNumber;
    }

    public void setLimitNumber(Integer limitNumber) {
        this.limitNumber = limitNumber;
    }

    @Override
    public String toString() {
        return "AdviseTeacherVo{" +
                "id=" + id +
                ", tid='" + tid + '\'' +
                ", tname='" + tname + '\'' +
                ", sex='" + sex + '\'' +
                ", workTime='" + workTime + '\'' +
                ", hdegree='" + hdegree + '\'' +
                ", teachingDirection='" + teachingDirection + '\'' +
                ", position='" + position + '\'' +
                ", department='" + department + '\'' +
                ", major='" + major + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", haveNumber=" + haveNumber +
                ", limitNumber=" + limitNumber +
                '}';
    }
}
