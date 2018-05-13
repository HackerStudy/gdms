package com.gdms.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="major")
public class Major {
    @Id
    @GeneratedValue(generator = "UUID")
    private Integer mid;

    private String majorName;

    private Integer did;

    public Major(Integer mid, String majorName, Integer did) {
        this.mid = mid;
        this.majorName = majorName;
        this.did = did;
    }

    public Major() {
    }

    public Integer getMid() {
        return mid;
    }

    public String getMajorName() {
        return majorName;
    }

    public Integer getDid() {
        return did;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    @Override
    public String toString() {
        return "Major{" +
                "mid=" + mid +
                ", majorName='" + majorName + '\'' +
                ", did=" + did +
                '}';
    }
}