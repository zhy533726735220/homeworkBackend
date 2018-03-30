package com.zhy.vo;

public class UserHomeworkType {
    private String openid;
    private int typeid;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public int getTypeid() {
        return typeid;
    }

    public void setTypeid(int typeid) {
        this.typeid = typeid;
    }

    @Override
    public String toString() {
        return "UserHomeworkType{" +
                "openid='" + openid + '\'' +
                ", typeid=" + typeid +
                '}';
    }
}
