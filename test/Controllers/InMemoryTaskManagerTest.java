package Controllers;

import Controllers.InMemoryTaskManager;
import Model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InMemoryTaskManagerTest {

    private InMemoryTaskManager taskManager;

    @BeforeEach
    void setUp() {
        taskManager = new InMemoryTaskManager();
    }

    @Test
    void testAddAndGetTask() {
        Task task = new Task("Новая задача", "Описание задачи", Status.NEW);
        taskManager.add(task);

        Task retrievedTask = taskManager.getById(task.getId());

        assertNotNull(retrievedTask, "Не удалось найти задачу по id");
        assertEquals(task, retrievedTask, "Полученная задача не соответствует добавленной");
    }

    @Test
    void testAddAndGetEpic() {
        Epic epic = new Epic("Новый эпик", "Описание эпика");
        taskManager.add(epic);

        Epic retrievedEpic = (Epic) taskManager.getById(epic.getId());

        assertNotNull(retrievedEpic, "Не удалось найти эпик по id");
        assertEquals(epic, retrievedEpic, "Полученный эпик не соответствует добавленному");
    }

    @Test
    void testAddAndGetSubtask() {
        Epic epic = new Epic("Новый эпик", "Описание эпика");
        taskManager.add(epic);

        Subtask subtask = new Subtask("Новая подзадача", "Описание подзадачи", Status.IN_PROGRESS, epic.getId());
        taskManager.add(subtask);

        Subtask retrievedSubtask = (Subtask) taskManager.getById(subtask.getId());

        assertNotNull(retrievedSubtask, "Не удалось найти подзадачу по id");
        assertEquals(subtask, retrievedSubtask, "Полученная подзадача не соответствует добавленной");
    }


}
