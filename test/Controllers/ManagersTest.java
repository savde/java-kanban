package Controllers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagersTest {
    @Test
    public void testDefaultTaskManager() {
        TaskManager taskManager = Managers.getDefault();

        assertNotNull(taskManager, "Менеджер задач не должен быть null");

        assertTrue(taskManager instanceof InMemoryTaskManager,
                "Менеджер задач должен быть экземпляром InMemoryTaskManager");
    }

    @Test
    public void testDefaultHistoryManager() {
        HistoryManager historyManager = Managers.getDefaultHistory();

        assertNotNull(historyManager, "Менеджер истории не должен быть null");

        assertTrue(historyManager instanceof InMemoryHistoryManager,
                "Менеджер истории должен быть экземпляром InMemoryHistoryManager");
    }

}