package MyVk;

import com.google.gson.annotations.SerializedName;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ResponseVk {
    @SerializedName("response")
    Groups response;

    public Groups getResponse() {
        return response;
    }

    public void setResponse(Groups response) {
        this.response = response;
    }

    public String getResponseVk(HttpClient client, HttpPost request){
        ResponseVk responseVk;
        HttpResponse response;
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

    }
}
