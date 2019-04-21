package com.hk.controller;

import com.alibaba.fastjson.JSONObject;
import com.hk.model.UserInfo;
import com.hk.service.sys.UserInfoService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/main")
public class MainController {

    @Autowired
    private UserInfoService userInfoService;

    @GetMapping("/test")
    public Object test(@RequestParam Integer uid) {
        UserInfo userInfo = userInfoService.getUserInfo(uid);
        JSONObject json = new JSONObject();
        if(null == userInfo) {
            json.put("code", "fail");
        } else {
            json.put("code", "success");
            json.put("userInfo", userInfo);
        }

        return json;
    }

    @PostMapping("/ajaxLogin")
    public Object ajaxLogin(UserInfo userInfo) {
        JSONObject jsonObject = new JSONObject();
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userInfo.getUsername(),
            userInfo.getPassword());
        try {
            subject.login(token);
            jsonObject.put("token", subject.getSession().getId());
            jsonObject.put("msg", "登录成功");
        } catch(IncorrectCredentialsException e) {
            jsonObject.put("msg", "密码错误");
        } catch(LockedAccountException e) {
            jsonObject.put("msg", "登录失败，该用户已被冻结");
        } catch(AuthenticationException e) {
            jsonObject.put("msg", "该用户不存在");
        } catch(Exception e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }
}
