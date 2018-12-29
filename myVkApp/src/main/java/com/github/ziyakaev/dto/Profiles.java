package com.github.ziyakaev.dto;


public class Profiles
{
    private String id;

    private String first_name;

    private String sex;

    private String photo_50;

    private String last_name;

    private String screen_name;

    private String type;

    private String photo_100;

    private String online;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getFirst_name ()
    {
        return first_name;
    }

    public void setFirst_name (String first_name)
    {
        this.first_name = first_name;
    }

    public String getSex ()
    {
        return sex;
    }

    public void setSex (String sex)
    {
        this.sex = sex;
    }

    public String getPhoto_50 ()
    {
        return photo_50;
    }

    public void setPhoto_50 (String photo_50)
    {
        this.photo_50 = photo_50;
    }

    public String getLast_name ()
    {
        return last_name;
    }

    public void setLast_name (String last_name)
    {
        this.last_name = last_name;
    }

    public String getScreen_name ()
    {
        return screen_name;
    }

    public void setScreen_name (String screen_name)
    {
        this.screen_name = screen_name;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    public String getPhoto_100 ()
    {
        return photo_100;
    }

    public void setPhoto_100 (String photo_100)
    {
        this.photo_100 = photo_100;
    }

    public String getOnline ()
    {
        return online;
    }

    public void setOnline (String online)
    {
        this.online = online;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", first_name = "+first_name+", sex = "+sex+", photo_50 = "+photo_50+", last_name = "+last_name+", screen_name = "+screen_name+", type = "+type+", photo_100 = "+photo_100+", online = "+online+"]";
    }
}