package com.zhy.service;

import com.zhy.vo.User;

public interface IUserService {
    /**
     * 查询是否是新用户
     * @param user
     * @return
     */
    public User findById(User user);
}
