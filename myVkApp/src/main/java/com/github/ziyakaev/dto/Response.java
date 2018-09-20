package com.github.ziyakaev.dto;

public class Response
{
    private String count;

    private Group[] items;

    public String getCount ()
    {
        return count;
    }

    public void setCount (String count)
    {
        this.count = count;
    }

    public Group[] getItems ()
    {
        return items;
    }

    public void setItems (Group[] items)
    {
        this.items = items;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [count = "+count+", items = "+items+"]";
    }
}