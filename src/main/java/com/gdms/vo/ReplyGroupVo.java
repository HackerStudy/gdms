package com.gdms.vo;

public class ReplyGroupVo {
    private Integer id;

    private String groupName;

    private String groupLeaderTid;

    private String groupLeaderName;

    private Integer groupTeacherNumber;

    private Integer groupStudentNumber;

    public ReplyGroupVo(Integer id, String groupName, String groupLeaderTid, String groupLeaderName, Integer groupTeacherNumber, Integer groupStudentNumber) {
        this.id = id;
        this.groupName = groupName;
        this.groupLeaderTid = groupLeaderTid;
        this.groupLeaderName = groupLeaderName;
        this.groupTeacherNumber = groupTeacherNumber;
        this.groupStudentNumber = groupStudentNumber;
    }

    public ReplyGroupVo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupLeaderTid() {
        return groupLeaderTid;
    }

    public void setGroupLeaderTid(String groupLeaderTid) {
        this.groupLeaderTid = groupLeaderTid;
    }

    public String getGroupLeaderName() {
        return groupLeaderName;
    }

    public void setGroupLeaderName(String groupLeaderName) {
        this.groupLeaderName = groupLeaderName;
    }

    public Integer getGroupTeacherNumber() {
        return groupTeacherNumber;
    }

    public void setGroupTeacherNumber(Integer groupTeacherNumber) {
        this.groupTeacherNumber = groupTeacherNumber;
    }

    public Integer getGroupStudentNumber() {
        return groupStudentNumber;
    }

    public void setGroupStudentNumber(Integer groupStudentNumber) {
        this.groupStudentNumber = groupStudentNumber;
    }

    @Override
    public String  toString() {
        return "ReplyGroupVo{" +
                "id=" + id +
                ", groupName='" + groupName + '\'' +
                ", groupLeaderTid='" + groupLeaderTid + '\'' +
                ", groupLeaderName='" + groupLeaderName + '\'' +
                ", groupTeacherNumber=" + groupTeacherNumber +
                ", groupStudentNumber=" + groupStudentNumber +
                '}';
    }
}
