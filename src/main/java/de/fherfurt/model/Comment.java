package de.fherfurt.model;

import de.fherfurt.core.entity.AbstractDatabaseEntity;


import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Date;


@Entity
public class Comment extends AbstractDatabaseEntity
{
    String text;
    int likes;
    @ManyToOne
    Ooser ooser;
    @ManyToOne
    Post post;

    public Comment(String text, int likes, Ooser creator, Post post){
        this.text = text;
        this.likes = likes;
        this.ooser = creator;
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


    public Ooser getOoser()
    {
        return ooser;
    }

    public void setOoser(Ooser ooser)
    {
        this.ooser = ooser;
    }


    public Post getPost()
    {
        return post;
    }

    public void setPost(Post post)
    {
        this.post = post;
    }

    @Override
    public int hashCode()
    {
        int result = text.hashCode();
        result = 31 * result + ooser.hashCode();
        return result;
    }

}