package com.gdms.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="review_status")
public class ReviewStatus {
    @Id
    @GeneratedValue(generator = "UUID")
    private Integer id;

    private String sid;

    private Integer openTopicStatus;

    private Integer midStatus;

    private Integer graduateStatus;

    private String tid;

    public ReviewStatus(Integer id, String sid, Integer openTopicStatus, Integer midStatus, Integer graduateStatus, String tid) {
        this.id = id;
        this.sid = sid;
        this.openTopicStatus = openTopicStatus;
        this.midStatus = midStatus;
        this.graduateStatus = graduateStatus;
        this.tid = tid;
    }

    public ReviewStatus() {
    }

    public Integer getId() {
        return id;
    }

    public String getSid() {
        return sid;
    }

    public Integer getOpenTopicStatus() {
        return openTopicStatus;
    }

    public Integer getMidStatus() {
        return midStatus;
    }

    public Integer getGraduateStatus() {
        return graduateStatus;
    }

    public String getTid() {
        return tid;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public void setOpenTopicStatus(Integer openTopicStatus) {
        this.openTopicStatus = openTopicStatus;
    }

    public void setMidStatus(Integer midStatus) {
        this.midStatus = midStatus;
    }

    public void setGraduateStatus(Integer graduateStatus) {
        this.graduateStatus = graduateStatus;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    @Override
    public String toString() {
        return "ReviewStatusService{" +
                "id=" + id +
                ", sid='" + sid + '\'' +
                ", openTopicStatus=" + openTopicStatus +
                ", midStatus=" + midStatus +
                ", graduateStatus=" + graduateStatus +
                ", tid='" + tid + '\'' +
                '}';
    }
}