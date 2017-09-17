package com.test.dao;

import com.test.pojo.UploadFile;

import java.util.List;

public interface UploadFileMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UploadFile record);

    int insertSelective(UploadFile record);

    UploadFile selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UploadFile record);

    int updateByPrimaryKey(UploadFile record);

    List<String> getAllFile();
}