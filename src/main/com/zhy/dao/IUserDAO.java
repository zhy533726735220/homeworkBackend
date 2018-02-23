package com.zhy.dao;

import com.zhy.vo.User;

public interface IUserDAO {
    public boolean findById(User vo);
    public boolean insertUser(User vo);
}
