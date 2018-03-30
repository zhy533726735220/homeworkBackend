package com.zhy.vo;

import java.util.Date;
import java.util.List;

public class User {
    private String openid;
    private String code;
    private String wxName;
    private String realName;
    private String avatar;
    private Integer admin;
    private Integer state;
    private Date updateTime;
    // 查询user时查询报课类型
    private List<HomeworkType> HomeworkTypeList;


    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getWxName() {
        return wxName;
    }

    public void setWxName(String wxName) {
        this.wxName = wxName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public List<HomeworkType> getHomeworkTypeList() {
        return HomeworkTypeList;
    }

    public void setHomeworkTypeList(List<HomeworkType> homeworkTypeList) {
        HomeworkTypeList = homeworkTypeList;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setAdmin(Integer admin) {
        this.admin = admin;
    }

    public Integer getAdmin() {
        return admin;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof User) {
            User vo = (User) obj;
            return (openid.equals(vo.openid));
        } else {
            return super.equals(obj);
        }

    }

    @Override
    public int hashCode() {
        return openid.hashCode();
    }

    @Override
    public String toString() {
        return "User{" +
                "openid='" + openid + '\'' +
                ", code='" + code + '\'' +
                ", wxName='" + wxName + '\'' +
                ", realName='" + realName + '\'' +
                ", avatar='" + avatar + '\'' +
                ", admin=" + admin +
                ", state=" + state +
                ", updateTime=" + updateTime +
                ", HomeworkTypeList=" + HomeworkTypeList +
                '}';
    }
}
