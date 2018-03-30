package com.zhy.service.impl;

import com.zhy.dao.IAdminDAO;
import com.zhy.service.IAdminService;
import com.zhy.vo.Homework;
import com.zhy.vo.HomeworkType;
import com.zhy.vo.User;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class AdminServiceImpl implements IAdminService {
    @Resource
    private IAdminDAO adminDAOImpl;

    @Override
    public List<Homework> selectStudyCondition(HashMap map) {
        return adminDAOImpl.selectStudyCondition(map);
    }

    @Override
    public List<User> selectUser() {
        return adminDAOImpl.selectUser();
    }
}
