package com.test.controller;

import com.test.common.Const;
import com.test.common.ServerResponse;
import com.test.pojo.User;
import com.test.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2017/8/2.
 */
@Controller
@RequestMapping("/user/")
public class UserController {

    @Resource
    private IUserService iUserService;

    @ResponseBody
    @RequestMapping("register")
    public ServerResponse register(User user){
        return iUserService.register(user);
    }

    @ResponseBody
    @RequestMapping("login")
    public ServerResponse<User> login(HttpSession session, String username,String password){
        ServerResponse<User> response = iUserService.login(username,password);
        if(response.isSuccess()){
            session.setAttribute(Const.CURRENT_USER,response.getData());
        }
        return response;
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
            return ServerResponse.createBySuccess(user);
        }
        return ServerResponse.createByErrorMessage("用户未登录，无法获取当前用户的信息");
    }


}
