package com.test.dao;

import com.test.pojo.WaterCard;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface WaterCardMapper {
    int deleteByPrimaryKey(String id);

    int insert(WaterCard record);

    int insertSelective(WaterCard record);

    WaterCard selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(WaterCard record);

    int updateByPrimaryKey(WaterCard record);

    WaterCard selectByCodePassowrd(@Param("code")String code, @Param("password")String password);

    List<WaterCard> selectByUserId(String userId);

    WaterCard selectByCode(String code);

    int  selectByCard(String code);

    void updateMoney(HashMap map);
}