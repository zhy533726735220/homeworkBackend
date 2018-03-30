package com.zhy.vo;

import java.util.Date;

public class Homework {
    private Integer id;
    private String openid;
    private String homeworkType;
    private String content;
    private Date updateTime;
    private Date submitTime;
    private User user;
    // 晚提交的人，标记为1
    private Integer laterSubmit;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getHomeworkType() {
        return homeworkType;
    }

    public void setHomeworkType(String homeworkType) {
        this.homeworkType = homeworkType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getLaterSubmit() {
        return laterSubmit;
    }

    public void setLaterSubmit(Integer laterSubmit) {
        this.laterSubmit = laterSubmit;
    }

    @Override
    public String toString() {
        return "Homework{" +
                "id=" + id +
                ", openid='" + openid + '\'' +
                ", homeworkType='" + homeworkType + '\'' +
                ", content='" + content + '\'' +
                ", updateTime=" + updateTime +
                ", submitTime=" + submitTime +
                ", user=" + user +
                ", laterSubmit=" + laterSubmit +
                '}';
    }
}


