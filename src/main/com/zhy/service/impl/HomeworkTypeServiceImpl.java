package com.zhy.service.impl;

import com.zhy.dao.IHomeworkTypeDAO;
import com.zhy.service.IHomeworkTypeService;
import com.zhy.vo.HomeworkType;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HomeworkTypeServiceImpl implements IHomeworkTypeService{

    @Resource
    private IHomeworkTypeDAO homeworkTypeDAOImpl;

    @Override
    public boolean doCreateHomeworkType(HomeworkType vos) {
        return homeworkTypeDAOImpl.insertHomeworkType(vos);
    }

    @Override
    public List<HomeworkType> selectHomeworkType(HomeworkType vo) {
        List<HomeworkType> vos = null;
        vos = homeworkTypeDAOImpl.selectHomeworkType(vo);
        return vos;
    }

    @Override
    public HomeworkType findHomeworkTypeDetailsBytypeId(String typeId) {
        return homeworkTypeDAOImpl.findHomeworkTypeDetailsBytypeId(typeId);
    }

    @Override
    public HomeworkType findTypeContentBytypeId(String typeContent) {
        return homeworkTypeDAOImpl.findTypeContentBytypeId(typeContent);
    }
}
