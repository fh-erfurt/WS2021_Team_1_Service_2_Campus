import de.fherfurt.campus.CampusLocation;
import de.fherfurt.campus.Campus;
import de.fherfurt.campus.Search;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.junit.Assert;

import java.util.Set;


public class SearchTest {

    @Test
    void shouldReturnCampusLocation(){
        //GIVEN
        //String name = "Altonaer Straße";
        Search search = new Search();
        CampusLocation TestLocation = new CampusLocation(2.1,1.1);

        //WHEN
        CampusLocation result = search.findByName("Altonaer Straße");

        //THEN
        //Assertions.assertThat(result).isEqualTo("Altonaer Straße");
        Assert.assertEquals(TestLocation.getLatCoord(), result.getLatCoord(), 0);
        Assert.assertEquals(TestLocation.getLongCoord(), result.getLongCoord(), 0);
}

    @Test
    void shouldReturnCampusLocation2(){
        //GIVEN
        //String name = "Altonaer Straße";
        Search search = new Search();
        CampusLocation TestLocation = new CampusLocation(2.1,1.1);
        Campus TestCampus = new Campus();
        TestCampus.setStreet("Altonaer Straße");

        //WHEN
        CampusLocation result = search.findByStreet(TestCampus);

        //THEN
        //Assertions.assertThat(result).isEqualTo("Altonaer Straße");
        Assert.assertEquals(TestLocation.getLatCoord(), result.getLatCoord(), 0);
        Assert.assertEquals(TestLocation.getLongCoord(), result.getLongCoord(), 0);
    }
}
