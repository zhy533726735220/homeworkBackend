package com.zhy.dao;

import com.zhy.vo.User;

public interface IUserDAO {
    /**
     * 根据用户的openid查询用户信息和报课类型
     * @param openid
     * @return
     */
    public User findUserDetailsByopenid(String openid);

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
