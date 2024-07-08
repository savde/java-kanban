import Model.*;
import Controllers.*;

public class Main {

    public static void main(String[] args) {
        TaskManager manager = Managers.getDefault(); // Получаем экземпляр TaskManager через утилитарный класс

        // Создаем задачи
        Task task1 = new Task("Задача 1", "Описание задачи 1", Status.NEW);
        Task task2 = new Task("Задача 2", "Описание задачи 2", Status.IN_PROGRESS);
        Epic epic1 = new Epic("Эпик 1", "Описание эпика 1");
        manager.add(task1);
        manager.add(task2);
        manager.add(epic1);


        Subtask subtask1 = new Subtask("Подзадача 1", "Описание подзадачи 1", Status.DONE, epic1.getId());

        manager.add(subtask1);

        // Выводим все задачи
        printAllTasks(manager);

        // Вызываем методы для получения задач по идентификаторам
        Task viewedTask1 = manager.getById(task1.getId());
        Task viewedSubtask1 = manager.getById(subtask1.getId());
        Task viewedEpic1 =  manager.getById(epic1.getId());

        // Выводим историю просмотров после вызова методов
        System.out.println("\nИстория просмотров после вызова методов:");
        printHistory(manager);
    }

    private static void printAllTasks(TaskManager manager) {
        System.out.println("Задачи:");
        for (Task task : manager.getTasks()) {
            System.out.println(task);
        }
        System.out.println("\nЭпики:");
        for (Task epic : manager.getEpics()) {
            System.out.println(epic);
            for (Task subtask : manager.getSubtasks((Epic) epic)) {
                System.out.println("--> " + subtask);
            }
        }
        System.out.println("\nПодзадачи:");
        for (Task subtask : manager.getSubTasks()) {
            System.out.println(subtask);
        }
    }

    private static void printHistory(TaskManager manager) {
        System.out.println("История просмотров задач:");
        for (Task task : manager.getHistory()) {
            System.out.println(task);
        }
    }
}
