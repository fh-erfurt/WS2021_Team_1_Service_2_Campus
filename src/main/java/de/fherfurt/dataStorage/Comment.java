package de.fherfurt.dataStorage;

import java.util.Date;

public class Comment extends BaseStorage
{
    String body;
    int likes;
    int dislikes;
    Date creationDate;
    User creator;
    Post commentedOn;

    public Comment(String body, int likes, int dislikes, User creator, Post commentedOn){
        this.body = body;
        this.likes = likes;
        this.dislikes = dislikes;
        this.creator = creator;
        this.commentedOn = commentedOn;
    }

    public Comment(){};

    public String getBody()
    {
        return body;
    }

    public void setBody(String body)
    {
        this.body = body;
    }


    public int getLikes()
    {
        return likes;
    }

    public void setLikes(int likes)
    {
        this.likes = likes;
    }


    public int getDislikes()
    {
        return dislikes;
    }

    public void setDislikes(int dislikes)
    {
        this.dislikes = dislikes;
    }


    public Date getCreationDate()
    {
        return creationDate;
    }

    public void setCreationDate(Date creationDate)
    {
        this.creationDate = creationDate;
    }


    public User getCreator()
    {
        return creator;
    }

    public void setCreator(User creator)
    {
        this.creator = creator;
    }


    public Post getCommentedOn()
    {
        return commentedOn;
    }

    public void setCommentedOn(Post commentedOn)
    {
        this.commentedOn = commentedOn;
    }

}