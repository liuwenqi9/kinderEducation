package com.muji.zh.student.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;

public class StatusUtil {
    public  static String getStatus(String status)
    {
        HashMap<String, String> map;
        map = new HashMap<>();

        map.put("status", status);
        System.out.println(map);
        //JSONObject jsonObject = JSONObject.fromObject(smallMap);
        JSONObject jsonObject1 = JSONObject.parseObject(JSON.toJSONString(map));

        System.out.println(jsonObject1.toJSONString());
        return jsonObject1.toJSONString();
    }

    public static  String getStr(String str) {

        str = str.trim();
        String str2 = "";
        if (str != null && !"".equals(str)) {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) >= 48 && str.charAt(i) <= 57) {
                    str2 += str.charAt(i);
                }
            }

        }
        return str2;
    }

}
