package com.github.ziyakaev;

import com.github.ziyakaev.dto.Board;
import com.github.ziyakaev.dto.Group;

public class GroupVk {
   private Group group;
   boolean isBoardEmpty=true;
   private Board boards;
    public GroupVk(){
        group=null;
        boards=null;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Group getGroup() {
        return group;
    }

    public void setBoards(Board boards) {
        this.boards = boards;
    }

    public Board getBoards() {
        return boards;
    }

    public void setBoardEmpty(boolean boardEmpty) {
        isBoardEmpty = boardEmpty;
    }

    public boolean isBoardEmpty() {
        return isBoardEmpty;
    }
}
