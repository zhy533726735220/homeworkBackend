package com.zhy.vo;

import java.util.Date;

public class Template {
    private Integer id;
    private String openid;
    private String templateType;
    private String content;
    private Integer state;
    private Date updateTime;

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

    public String getTemplateType() {
        return templateType;
    }

    public void setTemplateType(String templateType) {
        this.templateType = templateType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Template{" +
                "id=" + id +
                ", openid='" + openid + '\'' +
                ", templateType='" + templateType + '\'' +
                ", content='" + content + '\'' +
                ", state=" + state +
                ", updateTime=" + updateTime +
                '}';
    }
}
