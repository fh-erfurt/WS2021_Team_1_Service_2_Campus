package de.fherfurt.util;

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


        User karsten = new User();
        Post pfosten = new Post();

        userList.add( new User("karsten Müller", "Kart"));

        comments1.add(new Comment("Cooler Post", 34, karsten,pfosten ));

        posts1.add(new Post("Test", "Test Body", 23,karsten));
        posts1.add(new Post("Test2", "Test2 Body", 244, karsten));




        return userList;
    }
}
