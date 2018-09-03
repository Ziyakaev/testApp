package MyVk;

import com.google.gson.Gson;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Utils
{ public void request(String method, Map<String,String> map){
    HttpPost request;
    RequestVkApi requestVkApi=new RequestVkApi();
    request=requestVkApi.requestPost(method);
    List<NameValuePair> formparamsVk=new ArrayList<>();
    for (Map.Entry<String,String> iter:map.entrySet()) {
        formparamsVk.add(new BasicNameValuePair(iter.getKey(), iter.getValue()));
    }
    UrlEncodedFormEntity entity=new UrlEncodedFormEntity(formparamsVk, Consts.UTF_8);
    request.setEntity(entity);
    }
    public String response( HttpResponse response,HttpClient client, HttpPost request){
        StringBuilder sp=new StringBuilder();
        try {
            response= client.execute(request);
            HttpEntity httpEntity=response.getEntity();
            InputStream inputStream=httpEntity.getContent();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
            String s;
            while((s=bufferedReader.readLine())!=null){
                sp.append(s);
                System.out.println("response is"+s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    return sp.toString();
    }
    public ResponseVk helperParserFromJson( String dataResponse){
        Gson jsonFromVk=new Gson();
        ResponseVk responseVk=jsonFromVk.fromJson(dataResponse,ResponseVk.class);
        return responseVk;
    }
}
