import java.util.HashMap;

public class TaskManager {

    int nextId = 1;
    HashMap<Integer, Task> tasks = new HashMap<>();
    HashMap<Integer, Epic> epics = new HashMap<>();
    HashMap<Integer, Subtask> subTasks = new HashMap<>();

    public void add(Task task) {
        task.setId(nextId++);
        tasks.put(task.getId(), task);
    }

    public void add(Epic epic){

    }

    public void add(Subtask subtask){

    }
}
