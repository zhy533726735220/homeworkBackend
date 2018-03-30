package com.zhy.dao;

import com.zhy.vo.Template;

import java.util.List;

public interface ITemplateDAO {

    /**
     * 根据用户增加模板
     * @param vo
     * @return
     */
    public boolean insertTemplate(Template vo);

    /**
     * 根据id修改模板的状态：0为不显示
     * @param id
     * @return
     */
    public boolean updateTemplate(String id);

    /**
     * 根据微信的openid取得用户相应的模板
     * @param openid
     * @return
     */
    public List<Template> selectTemplate(String openid);


}
