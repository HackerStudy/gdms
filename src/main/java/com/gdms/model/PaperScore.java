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

    public PaperScore() {
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

    public void setId(Integer id) {
        this.id = id;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public void setPaperScore(Integer paperScore) {
        this.paperScore = paperScore;
    }

    @Override
    public String toString() {
        return "PaperScore{" +
                "id=" + id +
                ", sid='" + sid + '\'' +
                ", paperScore=" + paperScore +
                '}';
    }
}