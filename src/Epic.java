import java.util.ArrayList;

public class Epic extends Task {
    ArrayList<Integer> taskIds = new ArrayList<>();


    public Epic(String name, String description) {
        super(name, description, Status.NEW);
    }
}
