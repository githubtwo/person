package com.zick.JsonSample;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.*;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2017/8/8.
 */
public class ReadJsonFile {

    public static void main(String[] args) {

        String a = System.getProperty("user.dir");
        System.out.println(a);
        File file = new File(a + "\\src\\test\\java\\com\\zick\\JsonSample\\testJson.json");
        try {
            String content = FileUtils.readFileToString(file);
            System.out.println(content);
            User user = JSON.parseObject(content,User.class);

            System.out.println(user.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
