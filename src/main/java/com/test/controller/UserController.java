package com.test.controller;

import com.test.common.Const;
import com.test.common.ServerResponse;
import com.test.pojo.User;
import com.test.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2017/8/2.
 */
@RestController
@RequestMapping("/user/")
public class UserController {

    @Resource
    private IUserService iUserService;

    @PostMapping("register")
    public ServerResponse register(User user,HttpServletResponse response){

        response.setHeader("Access-Control-Allow-Origin", "*");
        return iUserService.register(user);
    }

    @ResponseBody
    @RequestMapping("login")
    public ServerResponse<User> login(HttpServletResponse response,HttpSession session, String username, String password){

        response.setHeader("Access-Control-Allow-Origin", "*");
        session.setMaxInactiveInterval(86400 * 30);
        ServerResponse<User> serverResponse = iUserService.login(username,password);
        if(serverResponse.isSuccess()){
            session.setAttribute(Const.CURRENT_USER,serverResponse.getData());
        }
        return serverResponse;
    }

    @ResponseBody
    @RequestMapping("logout")
    public ServerResponse logout(HttpSession session){
        session.removeAttribute(Const.CURRENT_USER);
        return ServerResponse.createBySuccess("退出成功");
    }

    @ResponseBody
    @RequestMapping("get_user_info")
    public ServerResponse getUserInfo(HttpSession session){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if(user != null){

            return iUserService.getUserInfo(user.getId());
        }
        return ServerResponse.createByErrorMessage("用户未登录，无法获取当前用户的信息");
    }


}
