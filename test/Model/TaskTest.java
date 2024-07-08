package Model;

import Controllers.InMemoryTaskManager;
import Model.Task;
import Model.Status;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {

    @Test
    public void testTaskEqualityById() {
        // Создаем две задачи с одинаковыми id
        Task task1 = new Task("Задача 1", "Описание 1", Status.NEW);
        Task task2 = new Task("Задача 2", "Описание 2", Status.IN_PROGRESS);

        task1.setId(1);
        task2.setId(1);

        // Проверяем, что задачи с одинаковым id равны
        assertEquals(task1, task2, "Задачи с одинаковым id должны быть равны");
    }


    @Test
    public void testEpicAndSubtaskEqualityById() {
        // Создаем эпик и подзадачу с одинаковыми id
        Epic epic = new Epic("Эпик 1", "Описание эпика");
        epic.setId(1);

        Subtask subtask = new Subtask("Подзадача 1", "Описание подзадачи", Status.IN_PROGRESS, 1);
        subtask.setId(1);


        assertEquals(epic.getId(), subtask.getId(), "Эпик и подзадача с одинаковым id должны быть равны");
    }


}