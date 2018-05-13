package com.gdms.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="teacher_topic")
public class TeacherTopic {
    @Id
    @GeneratedValue(generator = "UUID")
    private Integer id;

    private String topicName;

    private String tid;

    public TeacherTopic(Integer id, String topicName, String tid) {
        this.id = id;
        this.topicName = topicName;
        this.tid = tid;
    }

    public TeacherTopic() {
    }

    public Integer getId() {
        return id;
    }

    public String getTopicName() {
        return topicName;
    }

    public String getTid() {
        return tid;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    @Override
    public String toString() {
        return "TeacherTopic{" +
                "id=" + id +
                ", topicName='" + topicName + '\'' +
                ", tid='" + tid + '\'' +
                '}';
    }
}