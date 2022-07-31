package de.fherfurt.dataStorage;


import java.util.ArrayList;
import java.util.List;

public class Category extends BaseStorage
{
    public String title;
    public String description;
    public int followers;
    List<Post> posts = new ArrayList<Post>();

    public Category(String title, String description, int followers){
        this.title = title;
        this.description = description;
        this.followers = followers;
    }

    public Category(){};

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }


    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }


    public int getFollowers()
    {
        return followers;
    }

    public void setFollowers(int followers)
    {
        this.followers = followers;
    }


    public List<Post> getPosts()
    {
        return posts;
    }

    public void setPosts(List<Post> posts)
    {
        this.posts = posts;
    }




}