package com.zhy.dao;

import com.zhy.vo.Homework;
import com.zhy.vo.User;

import java.util.HashMap;
import java.util.List;

public interface IAdminDAO {

    /**
     * 查看报课情况
     * @param map
     * @return
     */
    public List<Homework> selectStudyCondition(HashMap map);

    /**
     * 查看注册通过的用户
     * @return
     */
    public List<User> selectUser();
}
