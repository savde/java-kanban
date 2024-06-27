package Controllers;

import Model.*;

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

    public Task getById(int id){    //получение задачи по id
        if(tasks.containsKey(id)){
            return tasks.get(id);
        }
        if(epics.containsKey(id)){
            return epics.get(id);
        }
        if(subTasks.containsKey(id)){
            return subTasks.get(id);
        }
        return null;
    }

    public void deleteById(int id){  //удаление по id
        if(tasks.containsKey(id)){
            tasks.remove(id);
        }
        if(epics.containsKey(id)){
            epics.get(id).taskIds.forEach(taskId -> subTasks.remove(taskId));
            epics.remove(id);
        }
        if(subTasks.containsKey(id)){
            subTasks.remove(id);
        }
    }

    public void add(Task task) { // создание задачи
        task.setId(nextId++);
        tasks.put(task.getId(), task);
    }

    public void add(Epic epic){     // создание объемной задачи
        epic.setId(nextId++);
        epics.put(epic.getId(), epic);

    }

    public void add(Subtask subtask){  // создание подзадачи
        subtask.setId(nextId++);
        subTasks.put(subtask.getId(), subtask);

        Epic epic = epics.get(subtask.getEpicId());
        epic.taskIds.add(subtask.getId());
    }

    public void update(Task task){ //обновление задачи
        tasks.put(task.getId(), task);
    }

    public void update(Epic epic){ // обновление эпика
        epics.put(epic.getId(), epic);
    }

    public void update(Subtask subtask){  // обновление подзадачи
        subTasks.put(subtask.getId(), subtask);

        Epic epic = epics.get(subtask.getEpicId());
        for(Integer id : epic.taskIds){
            if(subTasks.get(id).getStatus() != Status.DONE){
                epic.setStatus(Status.IN_PROGRESS);
                return;
            }
        }
        epic.setStatus(Status.DONE);
    }
    public ArrayList<Subtask> getSubtasks(Epic epic){  //получение списка подзадач определенного эпика
        ArrayList<Subtask> subtasks = new ArrayList<>();
        for(Integer id : epic.taskIds){
            subtasks.add(subTasks.get(id));
        }
        return subtasks;
    }
}
