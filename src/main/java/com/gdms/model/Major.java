package com.gdms.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="major")
public class Major {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer mid;

    private String majorName;

    private Integer did;

    public Major(Integer mid, String majorName, Integer did) {
        this.mid = mid;
        this.majorName = majorName;
        this.did = did;
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
}