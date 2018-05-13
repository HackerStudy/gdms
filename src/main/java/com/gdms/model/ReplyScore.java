package com.gdms.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="reply_score")
public class ReplyScore {
    @Id
    @GeneratedValue(generator = "UUID")
    private Integer id;

    private String sid;

    private Integer openTopicScore;

    private Integer midScore;

    private Integer graduateScore;

    private Integer replyScore;

    private Integer entryStatus;

    public ReplyScore(Integer id, String sid, Integer openTopicScore, Integer midScore, Integer graduateScore, Integer replyScore, Integer entryStatus) {
        this.id = id;
        this.sid = sid;
        this.openTopicScore = openTopicScore;
        this.midScore = midScore;
        this.graduateScore = graduateScore;
        this.replyScore = replyScore;
        this.entryStatus = entryStatus;
    }

    public ReplyScore() {
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

    public Integer getReplyScore() {
        return replyScore;
    }

    public Integer getEntryStatus() {
        return entryStatus;
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

    public void setReplyScore(Integer replyScore) {
        this.replyScore = replyScore;
    }

    public void setEntryStatus(Integer entryStatus) {
        this.entryStatus = entryStatus;
    }

    @Override
    public String toString() {
        return "ReplyScore{" +
                "id=" + id +
                ", sid='" + sid + '\'' +
                ", openTopicScore=" + openTopicScore +
                ", midScore=" + midScore +
                ", graduateScore=" + graduateScore +
                ", replyScore=" + replyScore +
                ", entryStatus=" + entryStatus +
                '}';
    }
}