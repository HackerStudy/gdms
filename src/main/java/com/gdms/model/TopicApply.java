package com.gdms.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="topic_apply")
public class TopicApply {
    @Id
    @GeneratedValue(generator = "UUID")
    private Integer id;

    private String topicName;

    private Integer type;

    private Integer passSituation;

    private String attachmentName;

    private String attachmentUrl;

    private String sid;

    public TopicApply(Integer id, String topicName, Integer type, Integer passSituation, String attachmentName, String attachmentUrl, String sid) {
        this.id = id;
        this.topicName = topicName;
        this.type = type;
        this.passSituation = passSituation;
        this.attachmentName = attachmentName;
        this.attachmentUrl = attachmentUrl;
        this.sid = sid;
    }

    public TopicApply() {
    }

    public Integer getId() {
        return id;
    }

    public String getTopicName() {
        return topicName;
    }

    public Integer getType() {
        return type;
    }

    public Integer getPassSituation() {
        return passSituation;
    }

    public String getAttachmentName() {
        return attachmentName;
    }

    public String getAttachmentUrl() {
        return attachmentUrl;
    }

    public String getSid() {
        return sid;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public void setPassSituation(Integer passSituation) {
        this.passSituation = passSituation;
    }

    public void setAttachmentName(String attachmentName) {
        this.attachmentName = attachmentName;
    }

    public void setAttachmentUrl(String attachmentUrl) {
        this.attachmentUrl = attachmentUrl;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    @Override
    public String toString() {
        return "TopicApply{" +
                "id=" + id +
                ", topicName='" + topicName + '\'' +
                ", type=" + type +
                ", passSituation=" + passSituation +
                ", attachmentName='" + attachmentName + '\'' +
                ", attachmentUrl='" + attachmentUrl + '\'' +
                ", sid='" + sid + '\'' +
                '}';
    }
}