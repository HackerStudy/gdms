package com.gdms.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="reply_group")
public class ReplyGroup {
    @Id
    @GeneratedValue(generator = "UUID")
    private Integer id;

    private String groupName;

    private String groupLeaderTid;

    private Integer groupTeacherNumber;

    private Integer groupStudentNumber;

    public ReplyGroup(Integer id, String groupName, String groupLeaderTid, Integer groupTeacherNumber, Integer groupStudentNumber) {
        this.id = id;
        this.groupName = groupName;
        this.groupLeaderTid = groupLeaderTid;
        this.groupTeacherNumber = groupTeacherNumber;
        this.groupStudentNumber = groupStudentNumber;
    }

    public ReplyGroup() {
    }

    public Integer getId() {
        return id;
    }

    public String getGroupName() {
        return groupName;
    }

    public String getGroupLeaderTid() {
        return groupLeaderTid;
    }

    public Integer getGroupTeacherNumber() {
        return groupTeacherNumber;
    }

    public Integer getGroupStudentNumber() {
        return groupStudentNumber;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void setGroupLeaderTid(String groupLeaderTid) {
        this.groupLeaderTid = groupLeaderTid;
    }

    public void setGroupTeacherNumber(Integer groupTeacherNumber) {
        this.groupTeacherNumber = groupTeacherNumber;
    }

    public void setGroupStudentNumber(Integer groupStudentNumber) {
        this.groupStudentNumber = groupStudentNumber;
    }

    @Override
    public String toString() {
        return "ReplyGroup{" +
                "id=" + id +
                ", groupName='" + groupName + '\'' +
                ", groupLeaderTid='" + groupLeaderTid + '\'' +
                ", groupTeacherNumber=" + groupTeacherNumber +
                ", groupStudentNumber=" + groupStudentNumber +
                '}';
    }
}