package de.fherfurt.model;


import de.fherfurt.core.entity.AbstractDatabaseEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User extends AbstractDatabaseEntity
{
    public String fullName;
    public String userName;
    public Date joined = new Date(Long.MIN_VALUE);
    public List<Post> posts = new ArrayList<Post>();
    public List<Comment> comments = new ArrayList<Comment>();

    public User(String fullName, String userName){
        this.fullName = fullName;
        this.userName = userName;
        //this.posts = posts;
        //this.comments = comments;
    };

    public User(){};

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getJoined() {
        return joined;
    }

    public void setJoined(Date joined) {
        this.joined = joined;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}