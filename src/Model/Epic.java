package Model;

import java.util.ArrayList;

public class Epic extends Task {
    private ArrayList<Integer> taskIds = new ArrayList<>();


    public Epic(String name, String description) {
        super(name, description, Status.NEW);
    }

    public ArrayList<Integer> getTaskIds() {
        return taskIds;
    }

    public void clearTaskIds(){
        taskIds.clear();
    }

    public void deleteTaskId(int id){
        taskIds.remove(id);
    }
}
