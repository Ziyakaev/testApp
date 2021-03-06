package com.github.ziyakaev.dto;

import com.github.ziyakaev.JsonHelper;
import com.github.ziyakaev.RequestVkApi;
import com.github.ziyakaev.Utils;

import java.util.*;

public class Group {

    private String id;
    private String photo_200;
    private String is_admin;
    private String photo_50;
    private String is_member;
    private String is_closed;
    private String name;
    private String screen_name;
    private String type;
    private String photo_100;
    private List<Board> boardList;

    public String getId() {
        return id;
    }

    public static Map<String, String> setParameterForGroup(String userId, String accessToken) {
        Map<String, String> map = new HashMap<>();
        map.put("extended", "1");
        map.put("user_id", userId);
        map.put("access_token", accessToken);
        map.put("v", "5.85");
        return map;
    }

    public void setBoards(List<Board> boards) {
        this.boardList = boards;
    }

    public List<Board> getBoardList() {
        return boardList;
    }

    public List<Board> getBoards() {
        Utils.sleep(Utils.getRandom());
        Utils.request("board.getTopics", RequestVkApi.setParameterForBoard(this.id, Utils.accessToken));
        JsonHelper jsonHelper = new JsonHelper();
        Boards boards = (Boards) jsonHelper.getJson(Utils.response(), Boards.class);
        this.boardList = new ArrayList(Arrays.asList(boards.getResponse().getItems()));
        return this.boardList;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhoto_200() {
        return photo_200;
    }

    public void setPhoto_200(String photo_200) {
        this.photo_200 = photo_200;
    }

    public String getIs_admin() {
        return is_admin;
    }

    public void setIs_admin(String is_admin) {
        this.is_admin = is_admin;
    }

    public String getPhoto_50() {
        return photo_50;
    }

    public void setPhoto_50(String photo_50) {
        this.photo_50 = photo_50;
    }

    public String getIs_member() {
        return is_member;
    }

    public void setIs_member(String is_member) {
        this.is_member = is_member;
    }

    public String getIs_closed() {
        return is_closed;
    }

    public void setIs_closed(String is_closed) {
        this.is_closed = is_closed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScreen_name() {
        return screen_name;
    }

    public void setScreen_name(String screen_name) {
        this.screen_name = screen_name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhoto_100() {
        return photo_100;
    }

    public void setPhoto_100(String photo_100) {
        this.photo_100 = photo_100;
    }

    @Override
    public String toString() {
        return "ClassPojo [id = " + id + ", photo_200 = " + photo_200 + ", is_admin = " + is_admin + ", photo_50 = " + photo_50 + ", is_member = " + is_member + ", is_closed = " + is_closed + ", name = " + name + ", screen_name = " + screen_name + ", type = " + type + ", photo_100 = " + photo_100 + "]";
    }
}
