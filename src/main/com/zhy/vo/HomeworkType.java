package com.zhy.vo;

import java.util.List;

public class HomeworkType {
    private Integer typeId;
    private String typeContent;
    private List<User> userList;

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeContent() {
        return typeContent;
    }

    public void setTypeContent(String typeContent) {
        this.typeContent = typeContent;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public String toString() {
        return "HomeworkType{" +
                "typeId=" + typeId +
                ", typeContent='" + typeContent + '\'' +
                ", userList=" + userList +
                '}';
    }
}
