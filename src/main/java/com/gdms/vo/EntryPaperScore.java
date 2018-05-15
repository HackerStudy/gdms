package com.gdms.vo;

public class EntryPaperScore {
    private Integer id;
    private String sid;
    private String name;
    private Integer paperScore;

    public EntryPaperScore(Integer id, String sid, String name, Integer paperScore) {
        this.id = id;
        this.sid = sid;
        this.name = name;
        this.paperScore = paperScore;
    }

    public EntryPaperScore() {
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

    public Integer getPaperScore() {
        return paperScore;
    }

    public void setPaperScore(Integer paperScore) {
        this.paperScore = paperScore;
    }

    @Override
    public String toString() {
        return "EntryPaperScore{" +
                "id=" + id +
                ", sid='" + sid + '\'' +
                ", name='" + name + '\'' +
                ", paperScore=" + paperScore +
                '}';
    }
}
