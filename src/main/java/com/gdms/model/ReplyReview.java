package com.gdms.model;


import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="reply_review")
public class ReplyReview {
    @Id
    @GeneratedValue(generator = "UUID")
    private Integer id;

    private String sid;

    private Integer openTopicScore;

    private Integer midScore;

    private Integer graduateScore;

    private String tid;

    public ReplyReview(Integer id, String sid, Integer openTopicScore, Integer midScore, Integer graduateScore, String tid) {
        this.id = id;
        this.sid = sid;
        this.openTopicScore = openTopicScore;
        this.midScore = midScore;
        this.graduateScore = graduateScore;
        this.tid = tid;
    }

    public ReplyReview() {
    }

    public Integer getId() {
        return id;
    }

    public String getSid() {
        return sid;
    }

    public Integer getOpenTopicScore() {
        return openTopicScore;
    }

    public Integer getMidScore() {
        return midScore;
    }

    public Integer getGraduateScore() {
        return graduateScore;
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

    public void setOpenTopicScore(Integer openTopicScore) {
        this.openTopicScore = openTopicScore;
    }

    public void setMidScore(Integer midScore) {
        this.midScore = midScore;
    }

    public void setGraduateScore(Integer graduateScore) {
        this.graduateScore = graduateScore;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    @Override
    public String toString() {
        return "ReplyReview{" +
                "id=" + id +
                ", sid='" + sid + '\'' +
                ", openTopicScore=" + openTopicScore +
                ", midScore=" + midScore +
                ", graduateScore=" + graduateScore +
                ", tid='" + tid + '\'' +
                '}';
    }
}