package Controllers;

public class Managers {
    public static TaskManager getDefault() {
        // Здесь можно реализовать логику выбора и создания нужной реализации TaskManager
        return new InMemoryTaskManager(); // По умолчанию возвращаем InMemoryTaskManager
    }
}
