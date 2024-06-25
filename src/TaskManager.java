import java.util.ArrayList;
import java.util.HashMap;

public class TaskManager {

    int nextId = 1;
    HashMap<Integer, Task> tasks = new HashMap<>();
    HashMap<Integer, Epic> epics = new HashMap<>();
    HashMap<Integer, Subtask> subTasks = new HashMap<>();

    public ArrayList<Task> getAllTasks(){               //Получение списка всех задач
        ArrayList<Task> allTasks = new ArrayList<>();
        for(Task t : tasks.values()){
            allTasks.add(t);
        }
        for(Epic e : epics.values()){
            allTasks.add(e);
        }
        for(Subtask s : subTasks.values()){
            allTasks.add(s);
        }
        return allTasks;
    }

    public void clearAll(){   //удаление всех задач
        tasks.clear();
        epics.clear();
        subTasks.clear();
    }

    public void add(Task task) {
        task.setId(nextId++);
        tasks.put(task.getId(), task);
    }

    public void add(Epic epic){
        epic.setId(nextId++);
        epics.put(epic.getId(), epic);

    }

    public void add(Subtask subtask){
        subtask.setId(nextId++);
        subTasks.put(subtask.getId(), subtask);

        Epic epic = epics.get(subtask.getEpicId());
        epic.taskIds.add(subtask.getId());
    }
}
