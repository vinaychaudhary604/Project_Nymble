
import java.util.List;
import java.util.ArrayList; 

// import org.junit.Test;
// import static org.junit.Assert.assertEquals; 

public class DestinationTest {
    public static void main(String[] args) {
        testAddActivity();
        testGetName();
        testGetActivities();
    }

    @Test
    public static void testAddActivity() {
        
        List<Activity> activities = new ArrayList<>();
        Destination destination = new Destination("City A", activities);

        Activity activity1 = new Activity("Sightseeing", "Explore the city", 50.0, 20, destination);
        Activity activity2 = new Activity("Hiking", "Scenic trail", 30.0, 15, destination);

        destination.addActivity(activity1);
        destination.addActivity(activity2);
        
        List<Activity> expectedActivities = List.of(activity1, activity2);
        assertEquals1(expectedActivities, destination.getActivities());
    }

    private static void assertEquals1(List<Activity> expectedActivities, List<Activity> list) {
    }

    @Test
    public static void testGetName() {
        
        List<Activity> activities = new ArrayList<>();
        Destination destination = new Destination("City B", activities);

        String actualName = destination.getName();

        assertEquals2("City B", actualName);
    }

    private static void assertEquals2(String string, String actualName) {
    }

    @Test
    public static void testGetActivities() {
        
        List<Activity> activities = new ArrayList<>();
        Destination destination = new Destination("City C", activities);

        List<Activity> actualActivities = destination.getActivities();

        assertEquals3(activities, actualActivities);
    }

    private static void assertEquals3(List<Activity> activities, List<Activity> actualActivities) {
    }
}
