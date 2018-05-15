package com.gdms.model;

public class AdviserScore {
    private Integer id;

    private String tid;

    private Integer adviserScore;

    private String sid;

    public AdviserScore(Integer id, String tid, Integer adviserScore, String sid) {
        this.id = id;
        this.tid = tid;
        this.adviserScore = adviserScore;
        this.sid = sid;
    }

    public AdviserScore() {
    }

    public Integer getId() {
        return id;
    }

    public String getTid() {
        return tid;
    }

    public Integer getAdviserScore() {
        return adviserScore;
    }

    public String getSid() {
        return sid;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public void setAdviserScore(Integer adviserScore) {
        this.adviserScore = adviserScore;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    @Override
    public String toString() {
        return "AdviserScore{" +
                "id=" + id +
                ", tid='" + tid + '\'' +
                ", adviserScore=" + adviserScore +
                ", sid='" + sid + '\'' +
                '}';
    }
}