package com.test.controller;

import com.test.common.Const;
import com.test.common.ResponseCode;
import com.test.common.ServerResponse;
import com.test.pojo.User;
import com.test.service.ICardService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2017/8/17.
 */
@RestController
@RequestMapping("/card/")
public class CardController {

    @Resource
    private ICardService iCardService;

    @RequestMapping("bind")
    public ServerResponse bindCard(HttpSession session, String code, String password, String remark){
        User user = (User) session.getAttribute(com.test.common.Const.CURRENT_USER);
        if(user == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());
        }
        return iCardService.bind(code,password,remark,user.getId());
    }

    @RequestMapping("setDefaul")
    public ServerResponse setDefault(HttpSession session,String code){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if(user == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());
        }
        return iCardService.setDefault(code,user.getId());
    }

    @RequestMapping("getAllCard")
    public ServerResponse getAllCard(HttpSession session){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if(user == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());
        }
        return iCardService.getAllCard(user.getId());
    }
}
