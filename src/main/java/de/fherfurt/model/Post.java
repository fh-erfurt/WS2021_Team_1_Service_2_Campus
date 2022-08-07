package de.fherfurt.model;


import de.fherfurt.core.entity.AbstractDatabaseEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Post extends AbstractDatabaseEntity
{
    private String title;
    private String text;
    private int likes;
    @ManyToOne
    private Ooser poster;
    /*@ManyToMany
    public List<Comment> comments = new ArrayList<Comment>();*/

    public Post(String title, String text, int likes, Ooser poster){
        this.title = title;
        this.text = text;
        this.likes = likes;
        this.poster = poster;
    }

    public Post(){};

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public Ooser getPoster() {
        return poster;
    }

    public void setPoster(Ooser poster) {
        this.poster = poster;
    }

    @Override
    public int hashCode()
    {
        int result = title.hashCode();
        result = 31 * result + poster.hashCode();
        return result;
    }

   /* public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }*/

}
