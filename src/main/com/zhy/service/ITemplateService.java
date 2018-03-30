package com.zhy.service;

import com.zhy.vo.Template;

import java.util.List;

public interface ITemplateService {
    public boolean doCreateTemplate(Template vo);

    /**
     * 所谓删除模板，就是把对应的模板的状态改为0，不显示而已
     * @param id
     * @return
     */
    public boolean deleteTemplate(String id);

    public List<Template> selectTemplate(String openid);
}
