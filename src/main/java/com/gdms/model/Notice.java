package com.gdms.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name="notice")
public class Notice {
    @Id
    @GeneratedValue(generator = "UUID")
    private Integer id;

    private String title;

    private Date time;

    private String url;

    public Notice(Integer id, String title, Date time, String url) {
        this.id = id;
        this.title = title;
        this.time = time;
        this.url = url;
    }

    public Notice() {
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Date getTime() {
        return time;
    }

    public String getUrl() {
        return url;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", time=" + time +
                ", url='" + url + '\'' +
                '}';
    }
}