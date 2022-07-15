package com.bug.henong.utils;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class MapFactory {
    public  Map<String, Object> getStringObjectMap(HttpSession session, String type) {

        session.setMaxInactiveInterval(60 * 60 * 2);
        //session过期时间设置为7200秒 即两小时

        Map<String,Object> map = new HashMap<>();
        map.put("message","ok");
        map.put("code",0);
        map.put("success","success");
        map.put("type",type);

        return map;
    }
}
