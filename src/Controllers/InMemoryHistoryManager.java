package Controllers;

import Model.Task;

import java.util.ArrayList;
import java.util.List;

public class InMemoryHistoryManager implements HistoryManager {
    private List<Task> history = new ArrayList<>();


    @Override
    public void add(Task task) {
        if (history.size()>=10)
            history.remove(0);
        history.add(task);
    }

    @Override
    public List<Task> getHistory() {
        return List.copyOf(history);
    }

    @Override
    public void remove(Task task) {
        history.remove(task);
    }


}
