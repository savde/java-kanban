import java.util.ArrayList;

public class Epic extends Task {
    ArrayList<Integer> taskIds = new ArrayList<>();


    public Epic(String name, String description, Status status) {
        super(name, description, status);
    }
}
