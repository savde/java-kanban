package Controllers;

import Model.*;

import java.util.ArrayList;
import java.util.HashMap;

public class TaskManager {

    private int nextId = 1;
    private HashMap<Integer, Task> tasks = new HashMap<>();
    private HashMap<Integer, Epic> epics = new HashMap<>();
    private HashMap<Integer, Subtask> subTasks = new HashMap<>();



    public ArrayList<Task> getTasks(){  //получение списка простых задач
        return new ArrayList<>(tasks.values());
    }

    public ArrayList<Epic> getEpics(){  // получение списка эпиков
        return new ArrayList<>(epics.values());
    }

    public ArrayList<Subtask> getSubTasks(){   //получение списка подзадач
        return new ArrayList<>(subTasks.values());
    }

    public void deleteTasks(){ //удаление простых задач
        tasks.clear();
    }

    public void deleteEpics(){ //удаление эпиков
        subTasks.clear();
        epics.clear();
    }

    public void deleteSubTasks(){ //удаление подзадач
        for(Epic e : epics.values()){
            e.clearTaskIds();
            updateEpicStatus(e);
        }
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
            epics.get(id).getTaskIds().forEach(taskId -> subTasks.remove(taskId));
            epics.remove(id);
        }
        if(subTasks.containsKey(id)){
            Epic e = epics.get(subTasks.get(id).getEpicId());
            e.deleteTaskId(id);
            subTasks.remove(id);
            updateEpicStatus(e);
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
        epic.getTaskIds().add(subtask.getId());
        updateEpicStatus(epic);
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
        for(Integer id : epic.getTaskIds()){
            if(subTasks.get(id).getStatus() != Status.DONE){
                epic.setStatus(Status.IN_PROGRESS);
                return;
            }
        }
        epic.setStatus(Status.DONE);
    }
    public ArrayList<Subtask> getSubtasks(Epic epic){  //получение списка подзадач определенного эпика
        ArrayList<Subtask> subtasks = new ArrayList<>();
        for(Integer id : epic.getTaskIds()){
            subtasks.add(subTasks.get(id));
        }
        return subtasks;
    }

    private void updateEpicStatus(Epic epic){ //обновление статуса эпика
        if (epic.getTaskIds().isEmpty()) {
            epic.setStatus(Status.NEW);
            return;
        }

        boolean allNew = true;
        boolean allDone = true;

        for(Integer id : epic.getTaskIds()){
            if(subTasks.get(id).getStatus() != Status.DONE){
                allDone = false;
            }
            if(subTasks.get(id).getStatus() != Status.NEW){
                allNew = false;
            }
        }
        if(allNew){
            epic.setStatus(Status.NEW);
            return;
        }
        if(allDone){
            epic.setStatus(Status.DONE);
            return;
        }
        epic.setStatus(Status.IN_PROGRESS);
    }
}
