package de.fherfurt.model;


import de.fherfurt.core.entity.AbstractDatabaseEntity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
public class User extends AbstractDatabaseEntity
{
    public String fullName;
    public String userName;
    public Date joined = new Date(Long.MIN_VALUE);


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

    @Override
    public int hashCode()
    {
        int result = userName.hashCode();
        result = 31 * result + fullName.hashCode();
        result = 31 * result + joined.hashCode();
        return result;
    }

}