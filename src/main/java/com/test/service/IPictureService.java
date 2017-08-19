package com.test.service;

import com.test.common.ServerResponse;
import com.test.pojo.User;

/**
 * Created by Administrator on 2017/8/3.
 */

public interface IPictureService {

    ServerResponse<String> updateUserImg(String userId, String filename, String username);
}
