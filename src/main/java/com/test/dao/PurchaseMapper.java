package com.test.dao;

import com.test.pojo.Purchase;

public interface PurchaseMapper {
    int deleteByPrimaryKey(String id);

    int insert(Purchase record);

    int insertSelective(Purchase record);

    Purchase selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Purchase record);

    int updateByPrimaryKey(Purchase record);
}