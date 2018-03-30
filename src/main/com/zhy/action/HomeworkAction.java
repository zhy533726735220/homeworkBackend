package com.zhy.action;

import com.alibaba.fastjson.JSON;
import com.zhy.service.IHomeworkService;
import com.zhy.vo.Homework;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/pages/back/homework/*")
public class HomeworkAction {

    @Resource
    private IHomeworkService homeworkServiceImpl;

    @RequestMapping(value = "doCreateHomework", produces = "text/json;charset=UTF-8")
    public @ResponseBody
    Object doCreateTemplate(Homework vo) {
        boolean flag;
        vo.setUpdateTime(new Date());
        Pattern pattern = Pattern.compile("\\d+.\\d+.\\d+|\\d+.\\d+|\\d+..\\d+..\\d+|\\d+..\\d+");
        Matcher matcher = pattern.matcher(vo.getContent());
        if (matcher.find()) {
            String test = matcher.group();
            Pattern pattern1 = Pattern.compile("\\d+");
            Matcher matcher1 = pattern1.matcher(test);
            ArrayList list = new ArrayList();
            while (matcher1.find()) {
                list.add(matcher1.group());
            }
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            switch (list.size()) {
                case 2:
                    String aa = "2018-" + list.get(0) + "-" + list.get(1);

                    try {
                        sdf.parse(aa);
                        vo.setSubmitTime(sdf.parse(aa));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    String bb = list.get(0) + "-" + list.get(1) + "-" + list.get(2);
                    try {
                        sdf.parse(bb);
                        vo.setSubmitTime(sdf.parse(bb));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println(bb);
                    break;
                default:
                    return JSON.toJSONString(false);
            }

        }
        flag = homeworkServiceImpl.doCreateHomework(vo);
        return JSON.toJSONString(flag);
    }
}
