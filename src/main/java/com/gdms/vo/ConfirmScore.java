package com.gdms.vo;

public class ConfirmScore {
    private Integer id;

    private String sid;

    private String name;

    private Integer adviserScore;

    private Integer replyScore;

    private Integer paperScore;

    public ConfirmScore(Integer id, String sid, String name, Integer adviserScore, Integer replyScore, Integer paperScore) {
        this.id = id;
        this.sid = sid;
        this.name = name;
        this.adviserScore = adviserScore;
        this.replyScore = replyScore;
        this.paperScore = paperScore;
    }

    public ConfirmScore() {
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

    public Integer getAdviserScore() {
        return adviserScore;
    }

    public void setAdviserScore(Integer adviserScore) {
        this.adviserScore = adviserScore;
    }

    public Integer getReplyScore() {
        return replyScore;
    }

    public void setReplyScore(Integer replyScore) {
        this.replyScore = replyScore;
    }

    public Integer getPaperScore() {
        return paperScore;
    }

    public void setPaperScore(Integer paperScore) {
        this.paperScore = paperScore;
    }

    @Override
    public String toString() {
        return "ConfirmScore{" +
                "id=" + id +
                ", sid='" + sid + '\'' +
                ", name='" + name + '\'' +
                ", adviserScore=" + adviserScore +
                ", replyScore=" + replyScore +
                ", paperScore=" + paperScore +
                '}';
    }
}
