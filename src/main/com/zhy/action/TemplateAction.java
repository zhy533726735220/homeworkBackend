package com.zhy.action;

import com.alibaba.fastjson.JSON;
import com.zhy.service.ITemplateService;
import com.zhy.vo.Template;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/pages/back/template/*")
public class TemplateAction {
    @Resource
    private ITemplateService templateServiceImpl;

    @RequestMapping(value = "doCreateTemplate", produces = "text/json;charset=UTF-8")
    public @ResponseBody Object doCreateTemplate(Template vo) {
        boolean flag;
        vo.setUpdateTime(new Date());
        flag = templateServiceImpl.doCreateTemplate(vo);
        return JSON.toJSONString(flag);
    }

    @RequestMapping(value = "deleteTemplate", produces = "text/json;charset=UTF-8")
    public @ResponseBody Object deleteTemplate(String id) {
        boolean flag;
        flag = templateServiceImpl.deleteTemplate(id);
        return JSON.toJSONString(flag);
    }

    @RequestMapping(value = "selectTemplate", produces = "text/json;charset=UTF-8")
    public @ResponseBody Object selectTemplate(String openid) {
        List<Template> vos = templateServiceImpl.selectTemplate(openid);
        return JSON.toJSONString(vos);
    }
}
