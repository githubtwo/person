package com.test.service.Impl;

import com.google.common.collect.Lists;
import com.test.dao.UploadFileMapper;
import com.test.pojo.UploadFile;
import com.test.service.IFileService;
import com.test.util.FTPUtil;
import org.apache.commons.collections.ListUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service("iFileService")
public class FileServiceImpl implements IFileService{
    private Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);

    @Resource
    UploadFileMapper fileMapper;

    public String upload(MultipartFile file, String path){
        String fileName = file.getOriginalFilename();

        //扩展名
        String fileExtensionName = fileName.substring(fileName.lastIndexOf(".") + 1);
        String uploadFileName= UUID.randomUUID().toString() + "." + fileExtensionName;
        logger.info("开始上传文件,上传文件的文件名:{},上传的路径:{},新文件名:{}",fileName,path,uploadFileName);

        File fileDir = new File(path);
        if(!fileDir.exists()){
            fileDir.setWritable(true);
            fileDir.mkdirs();
        }

        File targetFile = new File(path,fileName);

        try {
            file.transferTo(targetFile);
            //// TODO: 将targetFile上传到我们的ftp服务器上
            FTPUtil.uploadFile(Lists.newArrayList(targetFile));
            UploadFile uploadFile = new UploadFile(fileName, (double) file.getSize());
            fileMapper.insert(uploadFile);
            //// TODO: 上传完之后，
            targetFile.delete();

        } catch (IOException e) {
            logger.info("上传文件异常",e);
            return null;
        }

        return targetFile.getName();
    }

    public boolean downfile(String filename){
        if(FTPUtil.downloadFtpFile(filename)){
            return true;
        }
        return false;
    }

    public List<String> getAllFile(){
        List<String> list = fileMapper.getAllFile();
        if(list.size()>0){
            return list;
        }
        return null;
    }

}
