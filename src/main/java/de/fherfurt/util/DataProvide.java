package de.fherfurt.util;

import de.fherfurt.model.Comment;
import de.fherfurt.model.Ooser;
import de.fherfurt.model.Post;

import java.util.ArrayList;
import java.util.List;

public class DataProvide {

    public static List<Ooser> createTestData()
    {
        List <Ooser> ooserList = new ArrayList<>();
        List<Comment> comments1 = new ArrayList<>();
        List<Post> posts1 = new ArrayList<>();


        Ooser karsten = new Ooser();
        Post pfosten = new Post();

        ooserList.add(  new Ooser("karsten Müller", "Kart"));
        ooserList.add(  new Ooser("Test Dummy", "Dummy"));

        return ooserList;
    }
}
