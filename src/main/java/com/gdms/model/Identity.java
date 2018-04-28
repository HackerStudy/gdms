package com.gdms.model;

public class Identity {
    private int identity_id;
    private int userid;
    private int user_identity;

    public Identity(int identity_id, int userid, int user_identity) {
        this.identity_id = identity_id;
        this.userid = userid;
        this.user_identity = user_identity;
    }

    public Identity() {
    }

    public int getIdentity_id() {
        return identity_id;
    }

    public void setIdentity_id(int identity_id) {
        this.identity_id = identity_id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getUser_identity() {
        return user_identity;
    }

    public void setUser_identity(int user_identity) {
        this.user_identity = user_identity;
    }

    @Override
    public String toString() {
        return "Identity{" +
                "identity_id=" + identity_id +
                ", userid=" + userid +
                ", user_identity=" + user_identity +
                '}';
    }
}
