package com.test.service.Impl;

import com.github.pagehelper.StringUtil;
import com.test.common.ServerResponse;
import com.test.dao.UserMapper;
import com.test.pojo.User;
import com.test.service.IPictureService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/8/3.
 */
@Service("iPictureService")
public class PictureServiceImpl implements IPictureService {
    @Resource
    private UserMapper userMapper;



    public ServerResponse<String> updateUserImg(String userId,String filename, String username){
        if(StringUtil.isNotEmpty(filename) && StringUtil.isNotEmpty(username)){
            int updateResult = userMapper.updateUserImg(filename,username);
            if(updateResult > 0){
                User user = userMapper.selectByPrimaryKey(userId);
                return ServerResponse.createBySuccess(user.getImg());
            }
        }
        return ServerResponse.createByErrorMessage("参数错误");
    }



}
