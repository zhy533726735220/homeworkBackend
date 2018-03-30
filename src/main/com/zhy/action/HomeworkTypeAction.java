package com.zhy.action;

import com.alibaba.fastjson.JSON;
import com.zhy.service.IHomeworkTypeService;
import com.zhy.vo.HomeworkType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/pages/back/homeworkType/*")
public class HomeworkTypeAction {

    @Resource
    private IHomeworkTypeService homeworkTypeServiceImpl;
    /**
     * 管理员添加报课的类型
     * @param vo
     * @return
     */
    @RequestMapping(value = "doCreateHomeworkType", produces = "text/json;charset=UTF-8")
    public @ResponseBody
    Object doCreateHomeworkType(HomeworkType vo) {
        boolean flag;
        flag = homeworkTypeServiceImpl.doCreateHomeworkType(vo);
        return JSON.toJSONString(flag);
    }

    /**
     * 管理员查看报课类型
     * @param vo
     * @return
     */
    @RequestMapping(value = "selectHomeworkType", produces = "text/json;charset=UTF-8")
    public @ResponseBody Object selectHomeworkType(HomeworkType vo) {
        List<HomeworkType> vos = null;
        vos = homeworkTypeServiceImpl.selectHomeworkType(vo);
        return JSON.toJSONString(vos);
    }

    /**
     * 根据报课类型的typeId查询报课所有类型下的所有用户
     * @param typeId
     * @return
     */
    @RequestMapping(value = "findHomeworkTypeDetailsBytypeId", produces = "text/json;charset=UTF-8")
    public @ResponseBody Object findHomeworkTypeDetailsBytypeId(String typeId) {
        HomeworkType vo = homeworkTypeServiceImpl.findHomeworkTypeDetailsBytypeId(typeId);
        return JSON.toJSONString(vo);
    }

    /**
     * 根据报课类型的typeContent查询typeId　
     * @param typeContent
     * @return
     */
    @RequestMapping(value = "findTypeContentBytypeId", produces = "text/json;charset=UTF-8")
    public @ResponseBody Object findTypeContentBytypeId(String typeContent) {
        HomeworkType vo = homeworkTypeServiceImpl.findTypeContentBytypeId(typeContent);
        return JSON.toJSONString(vo);
    }
}
