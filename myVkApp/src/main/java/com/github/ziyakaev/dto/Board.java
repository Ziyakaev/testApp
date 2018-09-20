package com.github.ziyakaev.dto;


public class Board
{
    private String created_by;

    private String id;

    private String title;

    private String is_fixed;

    private String updated;

    private String created;

    private String is_closed;

    private String updated_by;

    private String comments;

    public String getCreated_by ()
    {
        return created_by;
    }

    public void setCreated_by (String created_by)
    {
        this.created_by = created_by;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public String getIs_fixed ()
    {
        return is_fixed;
    }

    public void setIs_fixed (String is_fixed)
    {
        this.is_fixed = is_fixed;
    }

    public String getUpdated ()
    {
        return updated;
    }

    public void setUpdated (String updated)
    {
        this.updated = updated;
    }

    public String getCreated ()
    {
        return created;
    }

    public void setCreated (String created)
    {
        this.created = created;
    }

    public String getIs_closed ()
    {
        return is_closed;
    }

    public void setIs_closed (String is_closed)
    {
        this.is_closed = is_closed;
    }

    public String getUpdated_by ()
    {
        return updated_by;
    }

    public void setUpdated_by (String updated_by)
    {
        this.updated_by = updated_by;
    }

    public String getComments ()
    {
        return comments;
    }

    public void setComments (String comments)
    {
        this.comments = comments;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [created_by = "+created_by+", id = "+id+", title = "+title+", is_fixed = "+is_fixed+", updated = "+updated+", created = "+created+", is_closed = "+is_closed+", updated_by = "+updated_by+", comments = "+comments+"]";
    }
}
