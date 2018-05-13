package com.gdms.model;

public class PaperScore {
    private Integer id;

    private String sid;

    private Integer paperScore;

    public PaperScore(Integer id, String sid, Integer paperScore) {
        this.id = id;
        this.sid = sid;
        this.paperScore = paperScore;
    }

    public Integer getId() {
        return id;
    }

    public String getSid() {
        return sid;
    }

    public Integer getPaperScore() {
        return paperScore;
    }
}