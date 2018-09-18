package com.github;

import dto.Group;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Utils {
    HttpPost request;
    private final HelperFilter helperFilter = new HelperFilter();

    public void request(String method, Map<String, String> map) {
        RequestVkApi requestVkApi = new RequestVkApi();
        request = requestVkApi.requestPost(method);
        List<NameValuePair> formparamsVk = Utils.buildParameterForRequest(map);
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparamsVk, Consts.UTF_8);
        request.setEntity(entity);
    }

    public static List<NameValuePair> buildParameterForRequest(Map<String, String> map) {
        List<NameValuePair> formparamsVk = new ArrayList<>();
        for (Map.Entry<String, String> iter : map.entrySet()) {
            formparamsVk.add(new BasicNameValuePair(iter.getKey(), iter.getValue()));
        }
        return formparamsVk;
    }

    public String response(HttpResponse response, HttpClient client) {
        StringBuilder sp = new StringBuilder();
        try {
            response = client.execute(request);
            HttpEntity httpEntity = response.getEntity();
            InputStream inputStream = httpEntity.getContent();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String s;
            while ((s = bufferedReader.readLine()) != null) {
                sp.append(s);
                System.out.println("response is" + s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sp.toString();
    }

    public void delimetersForGroup(Group[] groups, DataGroups dataGroups) {
        helperFilter.builderNameHouse();
        boolean f;
        for (Group group : groups) {
            f=false;
            for (String textFilter : helperFilter.nameHouse) {
                if (group.getName().toUpperCase().contains(textFilter.toUpperCase())) {
                    f = true;
                }
            }
            if (f) {
                dataGroups.groupToHouse.add(group);
                System.out.println(group.getName());
            } else {
                dataGroups.groupToOther.add(group);
            }

        }
    }

}
