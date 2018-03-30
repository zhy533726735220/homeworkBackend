package com.zhy.dao;

public interface IUserHomeworkTypeDAO {

    /**
     * 给新用户默认添加的报课课程
     * @return
     */
    public boolean insertUserHomeworkType(String openid);
}
