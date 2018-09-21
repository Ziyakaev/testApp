package com.github.ziyakaev;

import com.github.ziyakaev.dto.Board;
import com.github.ziyakaev.dto.Group;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Utils {
    private HttpPost request;
    private static int Random=(int) Math.random()%15+5;
    private final HelperFilter helperFilter = new HelperFilter();
    public final String messageTextToComment="Здесь НЕТ риэлторов и посредников, можно оставить объявление в этой группе и вступить) https://vk.com/kazan_home";

    public static int getRandom() {
        return Random;
    }

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

    public String response(HttpClient client) {
        StringBuilder sp = new StringBuilder();
        HttpClient client1 = HttpClientBuilder.create().build();
        HttpResponse response;
        try {
            response = client1.execute(request);
            System.out.println(response.getStatusLine());
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

    public void delimitersForGroup(Group[] groups, DataGroups dataGroups) {
        helperFilter.builderNameHouse();
        boolean f;
        for (Group group : groups) {
            f = false;
            for (String textFilter : helperFilter.nameHouse) {
                if (group.getName().toUpperCase().contains(textFilter.toUpperCase())) {
                    f = true;
                }
            }
            if (f) {
                dataGroups.addGroupToHouse(group);
                System.out.println(group.getName());
            } else {
                dataGroups.addGroupToOther(group);
            }

        }
    }
    public  boolean searchToBoard(Board board){
        boolean f=false;
        for(String filter:helperFilter.nameHouse)
        if (board.getTitle().toUpperCase().contains(filter.toUpperCase())){ f=true;
        }
        return f;

    }
    public  Board boadForGroupCollection(Board[] boards){
        Board board=null;
        for (int i=0;i<boards.length;i++){
            if (this.searchToBoard(boards[i])){board=boards[i];
            }
        }
        return board;
    }
    public void writeComments(String method,Map<String,String> map){
        this.request(method,map);
    }
    public void sleep(int second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
