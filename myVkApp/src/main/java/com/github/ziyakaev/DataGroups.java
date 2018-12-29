package com.github.ziyakaev;

import com.github.ziyakaev.dto.Board;
import com.github.ziyakaev.dto.Group;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class DataGroups {
    private List<Group> groupToHouse = new ArrayList<>();
    private List<Group> groupToOther = new ArrayList<>();

    private static final HelperFilter helperFilter = new HelperFilter();
    private static Logger logger = LogManager.getLogger(DataGroups.class);

    public void addGroupToHouse(Group data) {
        this.groupToHouse.add(data);
    }

    public void addGroupToOther(Group data) {
        this.groupToOther.add(data);

    }

    public void setGroupToHouse(Group group) {
        this.groupToHouse.add(group);
    }

    public void createTextForHouse() {
        for (Group group : groupToHouse) {
            Utils.sleep(Utils.getRandom());
            if (!this.createBoard(group.getId())) groupToOther.add(group);

        }
    }

    public List<Board> boadForGroupCollection(Group group) {
        List<Board> boardForComment = new ArrayList<>();
        Iterator<Board> iterator = group.getBoards().iterator();
        while (iterator.hasNext()) {
            Object object = iterator.next();
            if (!helperFilter.DoFilter(((Board) object).getTitle())) {
                iterator.remove();
            }
        }
        return boardForComment;
    }

    public void getBoardComment(List<Group> groups) {
        for (Group group : groups) {
            if (!group.getBoardList().isEmpty()) {
                group.getBoardList().forEach(board -> {
                    Utils.writeComments("board.createComment", RequestVkApi.setParameterForComments(group.getId(), board.getId(), Utils.messageTextToComment, Utils.accessToken));
                    logger.info("board create comment{}{}", group.getName(), board.getTitle());
                    Utils.sleep(Utils.getRandom());
                });

                Utils.response();
                Utils.sleep(Utils.getRandom());
            }
        }
    }

    public void createTextForOtherGroup() {
        for (Group group : groupToOther) {
            Utils.sleep(Utils.getRandom());
            this.boadForGroupCollection(group);
        }
    }


    public boolean createBoard(String id) {
        Utils.request("wall.post", Wall.setParameterForWall(id, Utils.messageTextToComment, Utils.accessToken));
        if (Utils.response().contains("error")) {
            return false;
        }
        return true;
    }

    public List<Group> getGroupToHouse() {
        return groupToHouse;
    }

    public List<Group> getGroupToOther() {
        return groupToOther;
    }
}
