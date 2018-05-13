package com.gdms.model;


import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="student_reply_score")
public class StudentReplyScore {
    @Id
    @GeneratedValue(generator = "UUID")
    private Integer id;

    private String sid;

    private Integer openTopicScore;

    private Integer midScore;

    private Integer graduateScore;

    public StudentReplyScore(Integer id, String sid, Integer openTopicScore, Integer midScore, Integer graduateScore) {
        this.id = id;
        this.sid = sid;
        this.openTopicScore = openTopicScore;
        this.midScore = midScore;
        this.graduateScore = graduateScore;
    }

    public StudentReplyScore() {
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

    @Override
    public String toString() {
        return "StudentReplyScore{" +
                "id=" + id +
                ", sid='" + sid + '\'' +
                ", openTopicScore=" + openTopicScore +
                ", midScore=" + midScore +
                ", graduateScore=" + graduateScore +
                '}';
    }
}