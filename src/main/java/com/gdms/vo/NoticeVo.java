package com.gdms.vo;

import java.io.Serializable;

public class NoticeVo implements Serializable {
    private Integer id;
    private String title;
    private String time;
    private String url;

    public NoticeVo(Integer id, String title, String time, String url) {
        this.id = id;
        this.title = title;
        this.time = time;
        this.url = url;
    }

    public NoticeVo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "NoticeVo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", time='" + time + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
