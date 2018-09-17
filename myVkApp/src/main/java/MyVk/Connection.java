package MyVk;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Connection {
    Token token=null;
    HttpClient client= HttpClientBuilder.create().build();
        String url="https://oauth.vk.com/authorize?client_id=3697615&display=page&redirect_uri=https://oauth.vk.com/blank.html&response_type=token&v=5.59";
        HttpPost request=new HttpPost(url);
        String acessToken="";
        int userId;
    public String getToken() {
//        RequestConfig customizedRequestConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.BROWSER_COMPATIBILITY).build();
//        HttpClientBuilder customizedClientBuilder = HttpClients.custom().setDefaultRequestConfig(customizedRequestConfig);
        HttpResponse response = null;
        try {
            response = client.execute(request);
        } catch (IOException e) {
            e.printStackTrace();
        }
        HttpEntity httpEntity = response.getEntity();
        InputStream inputStream = null;
        try {
            inputStream = httpEntity.getContent();
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s;
        String ip_h = null;
        String lg_h = null;
        try {
            while ((s = bufferedReader.readLine()) != null) {
                System.out.println("entity=" + s);
                if (s.contains("ip_h")) {
                    ip_h = s.substring(s.lastIndexOf("=\"") + 2, s.lastIndexOf("\""));
                }
                if (s.contains("lg_h")) {
                    lg_h = s.substring(s.lastIndexOf("=\"") + 2, s.lastIndexOf("\""));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Header header : response.getAllHeaders()) {
            System.out.println("header=" + header);
        }
        //  String HeaderLocation=response.getFirstHeader("Location").getValue();
        System.out.println(response.getStatusLine());
        System.out.println(response.getEntity());
        System.out.println(response.getLocale());
        System.out.println(lg_h);
        System.out.println(ip_h);
        request.abort();
        String email = "";
        String pass = "";
        request = new HttpPost("https://oauth.vk.com/token?grant_type=password&client_id=3697615&client_secret=AlVXZFMUqyrnABp8ncuU&username=89518983937&password=qwe123Z&v=5.71&2fa_supported=1");
        try {
        response = client.execute(request);

        httpEntity = response.getEntity();
        inputStream = httpEntity.getContent();
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        while ((s = bufferedReader.readLine()) != null) {
            token = gson.fromJson(s, Token.class);
            System.out.println("entity=" + s);
        }}catch (IOException e){ e.printStackTrace();}
        userId=token.userId;
        System.out.println(token.accessToken);
        System.out.println("tokenId="+token.userId);
        System.out.println(response.toString());
        return token.accessToken;
    }
//        request.setHeader("Content-Type","application/json");

//        StringEntity entity=new StringEntity();
//
//        URL obj=new URL(url);
//        HttpsURLConnection connection=(HttpsURLConnection) obj.openConnection();
        // optional default is GET
//        connection.setRequestMethod("GET");
        //add request header
//        int responseCode = connection.getResponseCode();
//        System.out.println("\nSending 'GET' request to URL : " + url);
//        System.out.println("Response Code : " + responseCode);
//        BufferedReader in = new BufferedReader(
//                new InputStreamReader(connection.getInputStream(),"cp1251"));
//        String inputLine;
//        StringBuffer response1 = new StringBuffer();
//
//        while ((inputLine = in.readLine()) != null) {
//            response1.append(inputLine);
//        }
//        in.close();
//
//        //print result
//        System.out.println(response1.toString());
//

}


