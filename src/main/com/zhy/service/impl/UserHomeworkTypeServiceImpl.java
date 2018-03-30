package com.zhy.service.impl;

import com.zhy.dao.IUserDAO;
import com.zhy.dao.IUserHomeworkTypeDAO;
import com.zhy.service.IUserHomeworkTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserHomeworkTypeServiceImpl implements IUserHomeworkTypeService{

    @Resource
    private IUserHomeworkTypeDAO userHomeworkTypeDAO;

    @Override
    public boolean insertUserHomeworkType(String openid) {
        return userHomeworkTypeDAO.insertUserHomeworkType(openid);
    }
}
