package Model;

import Controllers.InMemoryTaskManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubtaskTest {
    @Test
    public void cannotAssignSubtaskToItselfAsEpic() {
        InMemoryTaskManager taskManager = new InMemoryTaskManager();
        Epic epic = new Epic("Эпик 1", "Описание эпика 1");
        taskManager.add(epic);

        Subtask subtask = new Subtask("Подзадача 1", "Описание подзадачи 1", Status.NEW, epic.getId());

        assertThrows(IllegalArgumentException.class, () -> {
            taskManager.add(subtask);
        });
    }

}