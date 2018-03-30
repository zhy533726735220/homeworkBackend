package com.zhy.service.impl;

import com.zhy.dao.IHomeworkDAO;
import com.zhy.service.IHomeworkService;
import com.zhy.vo.Homework;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class HomeworkServiceImpl implements IHomeworkService{

    @Resource
    private IHomeworkDAO homeworkDAOImpl;

    @Override
    public Boolean doCreateHomework(Homework vo) {
        return homeworkDAOImpl.insertHomework(vo);
    }
}
