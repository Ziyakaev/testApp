package com.github.ziyakaev;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class AuthVk {
    private Token token = null;
    private HttpClient client = HttpClientBuilder.create().build();
    private String url = "https://oauth.vk.com/authorize?client_id=3697615&display=page&redirect_uri=https://oauth.vk.com/blank.html&response_type=token&v=5.59";
    private HttpPost request = new HttpPost(url);
    private String phoneNumber;
    private String password;
    private static final Logger logger = LogManager.getLogger(AuthVk.class);

    AuthVk(String phoneNumber, String password) {
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public Token getToken() throws IOException {
//        RequestConfig customizedRequestConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.BROWSER_COMPATIBILITY).build();
//        HttpClientBuilder customizedClientBuilder = HttpClients.custom().setDefaultRequestConfig(customizedRequestConfig);
        HttpResponse response = client.execute(request);
        HttpEntity httpEntity = response.getEntity();
        InputStream inputStream = httpEntity.getContent();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s;
        String ip_h = null;
        String lg_h = null;
        while ((s = bufferedReader.readLine()) != null) {
            System.out.println("entity=" + s);
            if (s.contains("ip_h")) {
                ip_h = s.substring(s.lastIndexOf("=\"") + 2, s.lastIndexOf("\""));
            }
            if (s.contains("lg_h")) {
                lg_h = s.substring(s.lastIndexOf("=\"") + 2, s.lastIndexOf("\""));
            }
        }

        for (Header header : response.getAllHeaders()) {
            logger.debug("header=" + header);
        }
        request.abort();

        request = new HttpPost(String.format("https://oauth.vk.com/token?grant_type=password&client_id=3697615&client_secret=AlVXZFMUqyrnABp8ncuU&username=%s&password=%s&v=5.71&2fa_supported=1", phoneNumber, password));
        response = client.execute(request);

        httpEntity = response.getEntity();
        inputStream = httpEntity.getContent();
        bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        JsonHelper jsonHelper = new JsonHelper();
        while ((s = bufferedReader.readLine()) != null) {
            token = (Token) jsonHelper.getJson(s, Token.class);
            System.out.println("entity=" + s);
        }
        System.out.println(response.toString());
        return token;
    }
}


