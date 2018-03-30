package com.zhy.action;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import com.zhy.service.IUserHomeworkTypeService;
import com.zhy.service.IUserService;

import com.zhy.vo.User;
import okhttp3.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;

@Controller
@RequestMapping("/pages/back/user/*")
public class UserAction {

    @Resource
    private IUserService userServiceImpl;
    @Resource
    private IUserHomeworkTypeService userHomeworkTypeService;

    /**
     * 根据openid查询用户的信息，查询出homeworkType表中的课程类型
     * @param openid
     * @return
     */
    @RequestMapping(value = "findUserDetailsByopenid", produces = "text/json;charset=UTF-8")
    public @ResponseBody Object findUserDetailsByopenid(String openid) {
        User vo = userServiceImpl.findUserDetailsByopenid(openid);
        return JSON.toJSONString(vo);
    }

    /**
     * 添加新用户
     * @param vo
     * @return
     */
    @RequestMapping(value = "insertUser", produces = "text/json;charset=UTF-8")
    public @ResponseBody Object insertUser(User vo) {
        String openid = null;
        String appid = "wxd9d56c1e140b5650";
        String secret = "ab3fcd51b47587779d848448a6b1b9ea";
        String grant_type = "authorization_code";
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + appid + "&secret=" + secret + "&grant_type=" + grant_type + "&js_code=" + vo.getCode();
        OkHttpClient okHttpClient = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .build();
        Call call = okHttpClient.newCall(request);
        try {
            Response response = call.execute();
            String json = response.body().string();
            JSONObject jsonObject = JSONObject.parseObject(json);
            System.out.println(jsonObject);
            openid = jsonObject.getString("openid");
            vo.setOpenid(openid);
        } catch (IOException e) {
            e.printStackTrace();
        }

        boolean flag = true;
        if (openid != null) {
            if (userServiceImpl.findByOpenid(vo.getOpenid()) != null) {
                User user = userServiceImpl.findUserDetailsByopenid(vo.getOpenid());
                return JSON.toJSONString(user);
            } else {
                vo.setUpdateTime(new Date());
                flag = userServiceImpl.insertUser(vo);
                userHomeworkTypeService.insertUserHomeworkType(vo.getOpenid());
                User user = userServiceImpl.findUserDetailsByopenid(vo.getOpenid());
                return JSON.toJSONString(user);
            }
        } else {
            flag = false;
            return JSON.toJSONString(flag);
        }

    }

    /**
     * 添加新用户
     * @param vo
     * @return
     */
    @RequestMapping(value = "updateUser", produces = "text/json;charset=UTF-8")
    public @ResponseBody Object updateUser(User vo) {
        Boolean flag = userServiceImpl.updateUser(vo);
        return JSON.toJSONString(flag);
    }

}
