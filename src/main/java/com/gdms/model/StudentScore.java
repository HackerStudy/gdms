package com.gdms.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name="student_score")
public class StudentScore {
    @Id
    @GeneratedValue(generator = "UUID")
    private Integer id;

    private String sid;

    private Integer adviserScore;

    private Integer replyScore;

    private Integer paperScore;

    private Integer totalScore;

    private Integer passStatus;

    public StudentScore(Integer id, String sid, Integer adviserScore, Integer replyScore, Integer paperScore, Integer totalScore, Integer passStatus) {
        this.id = id;
        this.sid = sid;
        this.adviserScore = adviserScore;
        this.replyScore = replyScore;
        this.paperScore = paperScore;
        this.totalScore = totalScore;
        this.passStatus = passStatus;
    }

    public StudentScore() {
    }

    public Integer getId() {
        return id;
    }

    public String getSid() {
        return sid;
    }

    public Integer getAdviserScore() {
        return adviserScore;
    }

    public Integer getReplyScore() {
        return replyScore;
    }

    public Integer getPaperScore() {
        return paperScore;
    }

    public Integer getTotalScore() {
        return totalScore;
    }

    public Integer getPassStatus() {
        return passStatus;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public void setAdviserScore(Integer adviserScore) {
        this.adviserScore = adviserScore;
    }

    public void setReplyScore(Integer replyScore) {
        this.replyScore = replyScore;
    }

    public void setPaperScore(Integer paperScore) {
        this.paperScore = paperScore;
    }

    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }

    public void setPassStatus(Integer passStatus) {
        this.passStatus = passStatus;
    }

    @Override
    public String toString() {
        return "StudentScore{" +
                "id=" + id +
                ", sid='" + sid + '\'' +
                ", adviserScore=" + adviserScore +
                ", replyScore=" + replyScore +
                ", paperScore=" + paperScore +
                ", totalScore=" + totalScore +
                ", passStatus=" + passStatus +
                '}';
    }
}