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
}