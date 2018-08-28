package MyVk;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
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

public class Board {
    BoardForTopic boardForTopic=new BoardForTopic();
    @SerializedName("id")
    int id;
    @SerializedName("title")
    String title;
    @SerializedName("created")
    int  created;
    @SerializedName("updated")
    int updated;
    @SerializedName("updated_by")
    int updatedBy;
    @SerializedName("is_closed")
    int isClosed;
    @SerializedName("is_fixed")
    int isFixed;
    @SerializedName("comments")
    int comments;

    Group group=new Group();
    public void getTopics(Group group, HttpClient client, String accessToken){
        this.group=group;
            RequestVkApi requestVkApi1 = new RequestVkApi();
            HttpPost request1 = requestVkApi1.requestPost("board.getTopics");
            System.out.println("request1=" + request1.toString());
            List<NameValuePair> formparamsVk1 = new ArrayList<NameValuePair>();
            formparamsVk1.add(new BasicNameValuePair("group_id", String.valueOf(group.id)));
            formparamsVk1.add(new BasicNameValuePair("access_token", accessToken));
            formparamsVk1.add(new BasicNameValuePair("v", "5.71"));
            HttpEntity entity1 = new UrlEncodedFormEntity(formparamsVk1, Consts.UTF_8);
            request1.setEntity(entity1);
            HttpResponse response1 = null;
            try {
                response1 = client.execute(request1);
                HttpEntity httpEntity1 = response1.getEntity();
                InputStream inputStream = httpEntity1.getContent();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String s1;
                GsonBuilder gsonBuilder=new GsonBuilder();
                Gson gson=gsonBuilder.create();
                while ((s1 = bufferedReader.readLine()) != null) {
                    System.out.println("Board is " + s1);
                    gson.fromJson(s1,Boards.class);
                    System.out.println();

                }
                request1.abort();
                Thread.sleep(5000);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
 public class BoardForTopic{
    int groupId;
    public void setTopic(int groupId) {
        this.groupId=groupId;

    }

     public int getGroupId() {
         return groupId;
     }
 }
}
