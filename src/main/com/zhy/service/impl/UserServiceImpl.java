package com.zhy.service.impl;

import com.zhy.dao.IUserDAO;
import com.zhy.service.IUserService;
import com.zhy.vo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements IUserService{

    @Resource
    private IUserDAO userDAOImpl;

    @Override
    public User findUserDetailsByopenid(String openid) {
        return userDAOImpl.findUserDetailsByopenid(openid);
    }

    @Override
    public boolean insertUser(User vo) {
        return userDAOImpl.insertUser(vo);
    }

    @Override
    public User findByOpenid(String openid) {
        return userDAOImpl.findByOpenid(openid);
    }

    @Override
    public Boolean updateUser(User vo) {
        return userDAOImpl.updateUser(vo);
    }
}
