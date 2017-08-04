package com.test.service;

import com.test.common.ServerResponse;
import com.test.pojo.User;

/**
 * Created by Administrator on 2017/8/2.
 */
public interface IUserService {
    ServerResponse register(User user);

    ServerResponse<User> login(String username,String password);
}
