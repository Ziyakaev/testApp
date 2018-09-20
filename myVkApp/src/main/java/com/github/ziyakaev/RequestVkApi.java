package com.github.ziyakaev;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RequestVkApi {
    private HttpPost request;
    private String methodName;
    private StringBuilder url = new StringBuilder("https://api.vk.com/method/");

    public HttpPost requestPost(String methodName) {
        this.methodName = methodName;
        url.append(methodName).append("?");
        request = new HttpPost(url.toString());
        return request;
    }

    public void setRequestPost(RequestVkApi requestVkApi, HttpPost request, HashMap<String, String> hashMap) {
        List<NameValuePair> formparamsVk1 = new ArrayList<NameValuePair>();
        for (Map.Entry<String, String> iter : hashMap.entrySet()) {
            formparamsVk1.add(new BasicNameValuePair(iter.getKey(), iter.getValue()));
        }
        HttpEntity entity = new UrlEncodedFormEntity(formparamsVk1, Consts.UTF_8);
        request.setEntity(entity);

    }
}
