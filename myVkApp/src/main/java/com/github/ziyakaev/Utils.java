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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Utils {
    private static HttpPost request;
    private static int Random = (int) Math.random() % 15 + 5;
    private static final HelperFilter helperFilter = new HelperFilter();
    public static String accessToken;
    private static final Logger logger = LogManager.getLogger("Utils");
    public static final String messageTextToComment = "Здесь НЕТ риэлторов и посредников, можно оставить объявление в этой группе и вступить) https://vk.com/kazan_home";

    public static int getRandom() {
        return Random;
    }

    public static void request(String method, Map<String, String> map) {
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

    public static String response() {
        StringBuilder sp = new StringBuilder();
        HttpClient client1 = HttpClientBuilder.create().build();
        HttpResponse response;
        try {
            response = client1.execute(request);
            logger.info("status line{}", response.getStatusLine());
            HttpEntity httpEntity = response.getEntity();
            InputStream inputStream = httpEntity.getContent();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String s;
            while ((s = bufferedReader.readLine()) != null) {
                sp.append(s);
                logger.info("response is{}", s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sp.toString();
    }

    public DataGroups delimitersForGroup(List<Group> groups) {
        logger.info("delimitersForGroup --> {}", groups);
        boolean isGroupForHouse;
        DataGroups dataGroups = new DataGroups();
        for (Group group : groups) {
            isGroupForHouse = false;
            if (helperFilter.DoFilter(group.getName().toUpperCase())) {
                isGroupForHouse = true;
            }
            if (isGroupForHouse) {
                dataGroups.addGroupToHouse(group);
                logger.info("group to house" + group.getName());
            } else {
                dataGroups.addGroupToOther(group);
                logger.info("group not house" + group.getName());
            }

        }
        logger.info("delimitersForGroup <-- {}", dataGroups);
        return dataGroups;
    }

    public static boolean searchToBoard(Board board) {
        boolean f = false;
        for (String filter : helperFilter.getKeyWorldsForHouseGroup())
            if (board.getTitle().toUpperCase().contains(filter.toUpperCase())) {
                f = true;
            }
        return f;

    }

    public List<Board> boadForGroupCollection(List<Board> boards) {
        List<Board> boardForComment = new ArrayList<>();
        for (Board board : boards) {
            if (Utils.searchToBoard(board)) {
                boardForComment.add(board);
            }
        }
        return boardForComment;
    }

    public static void writeComments(String method, Map<String, String> map) {
        request(method, map);
    }

    public static void sleep(int second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
    }

    public static List<String> readFile(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        return Files.readAllLines(path);
    }

    public static List<String> split(String data) {
        return Arrays.asList(data.split(","));
    }

}
