package com.gdms.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="identity")
public class Identity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private Integer identityId;

    private String identityname;

    private Integer groupId;

    public Identity(Integer id, Integer identityId, String identityname, Integer groupId) {
        this.id = id;
        this.identityId = identityId;
        this.identityname = identityname;
        this.groupId = groupId;
    }

    public Integer getId() {
        return id;
    }

    public Integer getIdentityId() {
        return identityId;
    }

    public String getIdentityname() {
        return identityname;
    }

    public Integer getGroupId() {
        return groupId;
    }
}