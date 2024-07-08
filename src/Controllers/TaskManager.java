package Controllers;

import Model.Epic;
import Model.Subtask;
import Model.Task;

import java.util.ArrayList;

public interface TaskManager {
    ArrayList<Task> getTasks();

    ArrayList<Epic> getEpics();

    ArrayList<Subtask> getSubTasks();

    void deleteTasks();

    void deleteEpics();

    void deleteSubTasks();

    Task getById(int id);

    void deleteById(int id);

    void add(Task task);

    void add(Epic epic);

    void add(Subtask subtask);

    void update(Task task);

    void update(Epic epic);

    void update(Subtask subtask);

    ArrayList<Subtask> getSubtasks(Epic epic);
}
