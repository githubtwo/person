package com.test.dao;

import com.test.pojo.Recharge;

public interface RechargeMapper {
    int deleteByPrimaryKey(String id);

    int insert(Recharge record);

    int insertSelective(Recharge record);

    Recharge selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Recharge record);

    int updateByPrimaryKey(Recharge record);
}