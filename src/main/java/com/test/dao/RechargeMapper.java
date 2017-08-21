package com.test.dao;

import com.test.pojo.Recharge;

import java.util.List;

public interface RechargeMapper {
    int deleteByPrimaryKey(String id);

    int insert(Recharge record);

    int insertSelective(Recharge record);

    Recharge selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Recharge record);

    int updateByPrimaryKey(Recharge record);

    List<Recharge> selectAllRecharge();
}