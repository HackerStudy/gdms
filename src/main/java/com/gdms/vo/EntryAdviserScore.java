package com.gdms.vo;

public class EntryAdviserScore {
    private Integer id;
    private String sid;
    private String name;
    private Integer adviserScore;

    public EntryAdviserScore(Integer id, String sid, String name, Integer adviserScore) {
        this.id = id;
        this.sid = sid;
        this.name = name;
        this.adviserScore = adviserScore;
    }

    public EntryAdviserScore() {
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

    @Override
    public String toString() {
        return "EntryAdviserScore{" +
                "id=" + id +
                ", sid='" + sid + '\'' +
                ", name='" + name + '\'' +
                ", adviserScore=" + adviserScore +
                '}';
    }
}
