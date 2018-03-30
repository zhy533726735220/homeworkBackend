package com.zhy.service;

public interface IUserHomeworkTypeService {
    /**
     * 给新用户默认添加的报课课程
     * @return
     */
    public boolean insertUserHomeworkType(String openid);
}
