package com.gdms.vo;

public class StudentTopicVo {
    private Integer id;
    private String sid;
    private String name;
    private String topicName;
    private String type;
    private String passSituation;
    private String attachmentName;

    public StudentTopicVo(Integer id, String sid, String name, String topicName, String type, String passSituation, String attachmentName) {
        this.id = id;
        this.sid = sid;
        this.name = name;
        this.topicName = topicName;
        this.type = type;
        this.passSituation = passSituation;
        this.attachmentName = attachmentName;
    }

    public StudentTopicVo() {
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

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPassSituation() {
        return passSituation;
    }

    public void setPassSituation(String passSituation) {
        this.passSituation = passSituation;
    }

    public String getAttachmentName() {
        return attachmentName;
    }

    public void setAttachmentName(String attachmentName) {
        this.attachmentName = attachmentName;
    }

    @Override
    public String toString() {
        return "StudentTopicVo{" +
                "id=" + id +
                ", sid='" + sid + '\'' +
                ", name='" + name + '\'' +
                ", topicName='" + topicName + '\'' +
                ", type='" + type + '\'' +
                ", passSituation='" + passSituation + '\'' +
                ", attachmentName='" + attachmentName + '\'' +
                '}';
    }
}
