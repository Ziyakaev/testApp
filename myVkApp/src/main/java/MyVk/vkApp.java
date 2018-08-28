package MyVk;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class vkApp {
    public static void main(String[] args) {
        Connection connection=new Connection();
        String accessToken=connection.getToken();
        System.out.println("token="+accessToken);
            HttpPost request;
        HttpResponse response = null;
        HttpClient client= HttpClientBuilder.create().build();
        RequestVkApi requestVkApi=new RequestVkApi();
        request=requestVkApi.requestPost("groups.get");
        System.out.println("userId="+connection.userId);
        List<NameValuePair> formparamsVk=new ArrayList<NameValuePair>();
        formparamsVk.add(new BasicNameValuePair("extended","1"));
        formparamsVk.add(new BasicNameValuePair("user_id",Integer.toString(connection.userId)));
        formparamsVk.add(new BasicNameValuePair("access_token",accessToken));
        formparamsVk.add(new BasicNameValuePair("v","5.80"));
        UrlEncodedFormEntity entity=new UrlEncodedFormEntity(formparamsVk,Consts.UTF_8);
        request.setEntity(entity);
//        request=new HttpPost("https://api.vk.com/method/groups.search?");
//        formparamsVk.add(new BasicNameValuePair("q","Снять квартиру в Казани"));
//        formparamsVk.add(new BasicNameValuePair("access_token",accessToken));
//        formparamsVk.add(new BasicNameValuePair("v","5.71"));
//        UrlEncodedFormEntity entity=new UrlEncodedFormEntity(formparamsVk, Consts.UTF_8);
//        request.setEntity(entity);
        JsonObject jsonObject1=null;
        JSONObject jsonObject=null;
        Gson jsonGroups=new Gson();
        Groups groups=new Groups();
        ResponseVk responseVk;
            try {
            response=client.execute(request);
        HttpEntity httpEntity=response.getEntity();
        InputStream inputStream=httpEntity.getContent();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
            String s; StringBuilder sp=new StringBuilder();
            while((s=bufferedReader.readLine())!=null){
                sp.append(s);
//              System.out.println("callMethod"+s);
//                jsonObject=new JSONObject(s).getJSONObject("response");
//               groups.count=jsonObject.getInt("count");
//               jsonArray=jsonObject.getJSONArray("items");

            }
                System.out.println(sp.toString());
            responseVk=jsonGroups.fromJson(sp.toString(),ResponseVk.class);
            groups=responseVk.response;
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("groups count"+groups.count);
        System.out.println("group item"+groups.items);
        String groupname;
        HelperFilter helperFilter=new HelperFilter();
        helperFilter.builderNameHouse();
        WriterGroups writerGroups=new WriterGroups();
        boolean f;
        for(int i=0;i<groups.count;i++){
            groupname=groups.items.get(i).name;
            f=false;
            for(String text:helperFilter.getNameHouse()) {
                if (groupname.toUpperCase().contains(text.toUpperCase())) {
                    f=true;
                }

            }
            if (f){writerGroups.addGroupsId(groups.items.get(i).id);
                System.out.println("groups name is house "+groupname+" "+groups.items.get(i).id);
            }
                 else { writerGroups.addGroupsIdForBoards(groups.items.get(i).id);
                 System.out.println("groups name not is house "+groupname+" "+groups.items.get(i).id);
            }
            }
            if (writerGroups.groupsIdForBoards.size()>0){
            for (int i=0;i<writerGroups.groupsIdForBoards.size();i++) {
                Board board=new Board();
                board.boardForTopic.setTopic(writerGroups.groupsId.get(i));
                RequestVkApi requestVkApi1=new RequestVkApi();
                HttpPost requestForBoards=requestVkApi1.requestPost("board.getTopics");
                HashMap<String,String> hasMap=new HashMap<>();
                int groupId=board.boardForTopic.getGroupId();
                hasMap.put("group_id",Integer.toString(groupId));
                requestVkApi1.setRequestPost(requestVkApi1,requestForBoards,hasMap);
            }
        }

          //  if(groups.items.get(i).id==125522346){board.getTopics(groups.items.get(i),client,accessToken);}
        request.abort();
        for(int i=0;i<groups.items.size();i++) {
            System.out.println(groups.items.get(i).name);
//            Wall wall = new Wall();
//            wall.ownerId = "-" + groups.items.get(i).id;
//            wall.FriendsOnly = 0;
//            wall.signed = "1";
//            wall.message = "Здесь НЕТ риэлторов и посредников, можно оставить объявление в этой группе и вступить) https://vk.com/kazan_home";
//            RequestVkApi requestVkApi1 = new RequestVkApi();
//            HttpPost request1 = requestVkApi1.requestPost("wall.post");
//            System.out.println("request1=" + request1.toString());
//            List<NameValuePair> formparamsVk1 = new ArrayList<NameValuePair>();
//            formparamsVk1.add(new BasicNameValuePair("owner_id", wall.ownerId));
//            formparamsVk1.add(new BasicNameValuePair("friends_only", Integer.toString(wall.FriendsOnly)));
//            formparamsVk1.add(new BasicNameValuePair("signed", wall.signed));
//            formparamsVk1.add(new BasicNameValuePair("message", wall.message));
//            formparamsVk1.add(new BasicNameValuePair("user_id", Integer.toString(connection.userId)));
//            formparamsVk1.add(new BasicNameValuePair("access_token", accessToken));
//            formparamsVk1.add(new BasicNameValuePair("v", "5.71"));
//            HttpEntity entity1 = new UrlEncodedFormEntity(formparamsVk1, Consts.UTF_8);
//            System.out.println(wall.ownerId);
//            request1.setEntity(entity1);
//            HttpResponse response1 = null;
//            try {
//                response1 = client.execute(request1);
//                HttpEntity httpEntity1 = response1.getEntity();
//                InputStream inputStream = httpEntity1.getContent();
//                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
//                String s1;
//                while ((s1 = bufferedReader.readLine()) != null) {
//                    System.out.println("callMethod wall post=" + s1);
//
//                }
//                request1.abort();
//                Thread.sleep(5000);
//            } catch (IOException e) {
//                e.printStackTrace();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

        }
   //     System.out.println("group="+jsonArray.toString());
        System.out.println("items"+groups.count);
    }
}
