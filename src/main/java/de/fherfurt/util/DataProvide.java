package de.fherfurt.util;

import de.fherfurt.model.Category;
import de.fherfurt.model.Comment;
import de.fherfurt.model.User;
import de.fherfurt.model.Post;

import java.util.ArrayList;
import java.util.List;

public class DataProvide {

    public static List<User> createTestData()
    {
        List <User> userList = new ArrayList<>();
        List<Comment> comments1 = new ArrayList<>();
        List<Post> posts1 = new ArrayList<>();
        List<Category> cats = new ArrayList<>();


        User Karsten = new User();
        Post pfosten = new Post();
        Category Posts = new Category("Posts", "Hier wird geposted", 12);

        userList.add( new User("Karsten Müller", "Kart", posts1, comments1, cats));

        comments1.add(new Comment("Cooler Post", 34, 1, Karsten,pfosten ));

        posts1.add(new Post("Test", "Test Body", "/post1", 23, 6, 24, Karsten, Posts));
        posts1.add(new Post("Test2", "Test2 Body", "/post2", 233, 65, 244, Karsten, Posts));

        cats.add(new Category("Posts", "Hier wird geposted", 12));




        return userList;
    }
}
