package com.test.service;

import com.test.common.ServerResponse;

/**
 * Created by Administrator on 2017/8/17.
 */
public interface ICardService {

    ServerResponse bind(String code, String password, String remark, String userId);

    ServerResponse setDefault(String code,String userId);

    boolean getCardNo(String cardNo);
}
