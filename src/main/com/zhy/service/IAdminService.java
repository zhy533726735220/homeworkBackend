package com.zhy.service;

import com.zhy.vo.Homework;
import com.zhy.vo.HomeworkType;
import com.zhy.vo.User;

import java.util.HashMap;
import java.util.List;

public interface IAdminService {

    /**
     * 查看报课情况
     * @param map
     * @return
     */
    public List<Homework> selectStudyCondition(HashMap map);

    public List<User>selectUser();
}
