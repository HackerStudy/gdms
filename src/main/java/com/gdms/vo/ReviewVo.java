package com.gdms.vo;

public class ReviewVo {
    private Integer id;
    private String tid;
    private String tname;
    private String sid;
    private String name;
    private Integer openTopicScore;
    private Integer midScore;
    private Integer graduateScore;

    public ReviewVo(Integer id, String tid, String tname, String sid, String name, Integer openTopicScore, Integer midScore, Integer graduateScore) {
        this.id = id;
        this.tid = tid;
        this.tname = tname;
        this.sid = sid;
        this.name = name;
        this.openTopicScore = openTopicScore;
        this.midScore = midScore;
        this.graduateScore = graduateScore;
    }

    public ReviewVo() {
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
        return "ReviewVo{" +
                "id=" + id +
                ", tid='" + tid + '\'' +
                ", tname='" + tname + '\'' +
                ", sid='" + sid + '\'' +
                ", name='" + name + '\'' +
                ", openTopicScore=" + openTopicScore +
                ", midScore=" + midScore +
                ", graduateScore=" + graduateScore +
                '}';
    }
}
