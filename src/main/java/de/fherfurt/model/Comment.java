package de.fherfurt.model;

import de.fherfurt.core.entity.AbstractDatabaseEntity;


import java.util.Date;

public class Comment extends AbstractDatabaseEntity
{
    String text;
    int likes;
    Date creationDate;
    User user;
    Post post;

    public Comment(String text, int likes, User creator, Post post){
        this.text = text;
        this.likes = likes;
        this.user = creator;
        this.post = post;
    }

    public Comment(){};

    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }


    public int getLikes()
    {
        return likes;
    }

    public void setLikes(int likes)
    {
        this.likes = likes;
    }


    public Date getCreationDate()
    {
        return creationDate;
    }

    public void setCreationDate(Date creationDate)
    {
        this.creationDate = creationDate;
    }


    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }


    public Post getPost()
    {
        return post;
    }

    public void setPost(Post post)
    {
        this.post = post;
    }

}