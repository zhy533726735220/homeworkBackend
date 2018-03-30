package com.zhy.action;

import com.alibaba.fastjson.JSON;

import com.zhy.service.IAdminService;
import com.zhy.service.IHomeworkTypeService;
import com.zhy.vo.Homework;
import com.zhy.vo.HomeworkType;
import com.zhy.vo.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/pages/back/admin/*")
public class AdminAction {

    @Resource
    private IAdminService adminServiceImpl;
    @Resource
    private IHomeworkTypeService homeworkTypeServiceImpl;
    /**
     * 查看报课情况
     * @param submitTime
     * @return
     */
    @RequestMapping(value = "selectStudyCondition", produces = "text/json;charset=UTF-8")
    public @ResponseBody Object selectStudyCondition(String submitTime, String homeworkType) {
        HashMap<String, String> map = new HashMap<>();
        map.put("submitTime", submitTime);
        map.put("homeworkType", homeworkType);
        List<Homework> vos = adminServiceImpl.selectStudyCondition(map);
        for (Homework vo : vos) {
            if (vo.getSubmitTime().getTime() < vo.getUpdateTime().getTime()) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                String dateTime = sdf.format(vo.getUpdateTime());
                String hour = dateTime.substring(11, 13);
                if (new Integer(hour) > 12) {
                    vo.setLaterSubmit(1);
                }
            }
        }
        return JSON.toJSONString(vos);
    }

    /**
     * 选出未报课的人
     * @param submitTime
     * @return
     */
    @RequestMapping(value = "selectUser", produces = "text/json;charset=UTF-8")
    public @ResponseBody Object selectUser(String submitTime, String homeworkType) {
        HashMap<String, String> map = new HashMap<>();
        map.put("submitTime", submitTime);
        map.put("homeworkType", homeworkType);
        // 查看相应的类型报课的情况
        List<Homework> vos = adminServiceImpl.selectStudyCondition(map);
        // 查看相应类型对应的所有成员
        HomeworkType typeId = homeworkTypeServiceImpl.findTypeContentBytypeId(homeworkType);
        HomeworkType vo = homeworkTypeServiceImpl.findHomeworkTypeDetailsBytypeId(typeId.getTypeId().toString());
        List<User> allStudent = vo.getUserList();
        System.out.println(allStudent);
        List<User> subStudents = new ArrayList<>();
        // todo 去重复方法垃圾
        for (Homework homework : vos) {
            subStudents.add(homework.getUser());
        }

        allStudent.removeAll(subStudents);

        return JSON.toJSONString(allStudent);
    }
}
