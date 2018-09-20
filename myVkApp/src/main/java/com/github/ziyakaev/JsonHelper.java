package com.github.ziyakaev;
import com.google.gson.Gson;

public class JsonHelper {
    public Object getJson(String data, Class vkClass){
        Gson json=new Gson();
        Object groups=json.fromJson(data,vkClass);
        return groups;
    }

}
