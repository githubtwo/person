package com.zick.JsonSample;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/8.
 */
public class JsonObject {

    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        JSONObject object = new JSONObject();
        Map<String,Object> map = new HashMap<>();
        map.put("key","word");
        map.put("sa","da");

        jsonObject.put("name","hello");
        jsonObject.put("phone","110");
        object.put("price","100");
        object.put("sale","10");
        jsonObject.put("data",object);
        jsonObject.put("string",new String[]{"hell","dsa"});
        jsonObject.put("map",map);

        System.out.println(jsonObject.toJSONString());


        String json = "{\"id\":0,\"name\":\"admin\"}";
        User user = JSON.parseObject(json,User.class);

        System.out.println(user.getId());
        System.out.println(user.getName());
    }
}
