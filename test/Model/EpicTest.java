package Model;

import Controllers.InMemoryTaskManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EpicTest {

    @Test
    public void epicCannotBeAddedAsSubtaskToItself() {
        // Создаем менеджер задач
        InMemoryTaskManager taskManager = new InMemoryTaskManager();

        // Создаем эпик
        Epic epic = new Epic("Epic 1", "Description of Epic 1");

        // Пытаемся добавить эпик в самого себя в виде подзадачи
        assertThrows(IllegalArgumentException.class, () -> {
            taskManager.add(epic); // Добавляем эпик в менеджер
            taskManager.add(new Subtask("Subtask 1", "Description of Subtask 1", Status.NEW, epic.getId()));
        }, "Ожидалось, что будет выброшено исключение IllegalArgumentException");
    }
}