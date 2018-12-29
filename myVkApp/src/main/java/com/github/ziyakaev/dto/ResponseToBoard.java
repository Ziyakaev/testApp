package com.github.ziyakaev.dto;

public class ResponseToBoard {
    private String default_order;

    private String count;

    private Board[] items;

    private Profiles[] profiles;

    private String can_add_topics;

    public String getDefault_order() {
        return default_order;
    }

    public void setDefault_order(String default_order) {
        this.default_order = default_order;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public Board[] getItems() {
        return items;
    }

    public void setItems(Board[] items) {
        this.items = items;
    }

    public Profiles[] getProfiles() {
        return profiles;
    }

    public void setProfiles(Profiles[] profiles) {
        this.profiles = profiles;
    }

    public String getCan_add_topics() {
        return can_add_topics;
    }

    public void setCan_add_topics(String can_add_topics) {
        this.can_add_topics = can_add_topics;
    }

    @Override
    public String toString() {
        return "ClassPojo [default_order = " + default_order + ", count = " + count + ", items = " + items + ", profiles = " + profiles + ", can_add_topics = " + can_add_topics + "]";
    }

}
