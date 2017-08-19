package com.test.service;

import com.test.common.ServerResponse;

/**
 * Created by Administrator on 2017/8/17.
 */
public interface IOrderService {

    ServerResponse pay(String cardNo,Integer money,String userId);

    void createRecharge(Float price, String cardNo, String userId, String orderId);
}
