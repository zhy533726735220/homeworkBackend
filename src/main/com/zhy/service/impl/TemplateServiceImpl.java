package com.zhy.service.impl;

import com.zhy.dao.ITemplateDAO;
import com.zhy.service.ITemplateService;
import com.zhy.vo.Template;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TemplateServiceImpl implements ITemplateService{

    @Resource
    private ITemplateDAO templateDAOImpl;

    @Override
    public boolean doCreateTemplate(Template vo) {
        return templateDAOImpl.insertTemplate(vo);
    }

    @Override
    public boolean deleteTemplate(String id) {
        return templateDAOImpl.updateTemplate(id);
    }

    @Override
    public List<Template> selectTemplate(String openid) {
        return templateDAOImpl.selectTemplate(openid);
    }
}
