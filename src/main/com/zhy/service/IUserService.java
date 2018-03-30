package com.zhy.service;

import com.zhy.vo.User;

public interface IUserService {
    /**
     * 根据openid查询用户的信息，查询出homeworkType表中的课程类型
     * @param openid
     * @return
     */
    public User findUserDetailsByopenid(String openid);

    /**
     * 添加新的用户
     * @param vo
     * @return
     */
    public boolean insertUser(User vo);

    /**
     * 根据openid查询用户是否存在
     * @param openid
     * @return
     */
    public User findByOpenid(String openid);

    /**
     * 更新用户信息
     * @param vo
     * @return
     */
    public Boolean updateUser(User vo);

}
