package com.test.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IFileService {

    String upload(MultipartFile file, String path);

    List<String> getAllFile();

    boolean downfile(String filename);
}
