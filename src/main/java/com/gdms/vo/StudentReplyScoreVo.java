package com.gdms.vo;

public class StudentReplyScoreVo {
    private Integer id;
    private String sid;
    private String name;
    private Integer openTopicScore;
    private Integer midScore;
    private Integer graduateScore;

    public StudentReplyScoreVo(Integer id, String sid, String name, Integer openTopicScore, Integer midScore, Integer graduateScore) {
        this.id = id;
        this.sid = sid;
        this.name = name;
        this.openTopicScore = openTopicScore;
        this.midScore = midScore;
        this.graduateScore = graduateScore;
    }

    public StudentReplyScoreVo() {
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

    public Integer getOpenTopicScore() {
        return openTopicScore;
    }

    public void setOpenTopicScore(Integer openTopicScore) {
        this.openTopicScore = openTopicScore;
    }

    public Integer getMidScore() {
        return midScore;
    }

    public void setMidScore(Integer midScore) {
        this.midScore = midScore;
    }

    public Integer getGraduateScore() {
        return graduateScore;
    }

    public void setGraduateScore(Integer graduateScore) {
        this.graduateScore = graduateScore;
    }

    @Override
    public String toString() {
        return "StudentReplyScoreVo{" +
                "id=" + id +
                ", sid='" + sid + '\'' +
                ", name='" + name + '\'' +
                ", openTopicScore=" + openTopicScore +
                ", midScore=" + midScore +
                ", graduateScore=" + graduateScore +
                '}';
    }
}
