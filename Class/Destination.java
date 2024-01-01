
import java.util.List;
// import java.util.ArrayList;

public class Destination {
    private String name;
    private List<Activity> activities;

    public Destination(String name, List<Activity> activities) {
        this.name = name;
        this.activities = activities;
    }

    public String getName() {
        return name;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void addActivity(Activity activity) {
        activities.add(activity);
    }
}