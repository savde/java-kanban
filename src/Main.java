import Controllers.TaskManager;
import Model.*;

public class Main {

    public static void main(String[] args) {
        TaskManager tm = new TaskManager();

        Task firstTask = new Task("Купить продукты", "Покупка огурцов, помидоров, зелени для салата", Status.NEW);
        tm.add(firstTask);

        Task secondTask = new Task("Аренда беседки", "Арендовать беседку на выходные", Status.NEW);
        tm.add(secondTask);

        Epic fitstEpic = new Epic("Завершение спринта", "Завершение четвертого спринта обучения");
        tm.add(fitstEpic);

        Subtask stOne = new Subtask("Теория", "Изучение теоретической части спринта", Status.NEW, fitstEpic.getId());
        Subtask stTwo = new Subtask("Задание", "Выполнение финального задания спринта", Status.NEW, fitstEpic.getId());
        tm.add(stOne);
        tm.add(stTwo);

        Epic secondEpic = new Epic("Концепция нового продукта", "Написать и представить концепцию нового продукта");
        tm.add(secondEpic);

        Subtask st = new Subtask("Список характеристик", "Составить список характеристик и функций нового продукта", Status.NEW, secondEpic.getId());
        tm.add(st);



        tm.getTasks().forEach(task -> {System.out.println(task.getName() + " " + task.getStatus());});
        tm.getEpics().forEach(task -> {System.out.println(task.getName() + " " + task.getStatus());});
        tm.getSubTasks().forEach(task -> {System.out.println(task.getName() + " " + task.getStatus());});
        System.out.println();

        firstTask.setStatus(Status.DONE);
        tm.update(firstTask);

        stOne.setStatus(Status.DONE);
        tm.update(stOne);

        stTwo.setStatus(Status.IN_PROGRESS);
        tm.update(stTwo);

        st.setStatus(Status.DONE);
        tm.update(st);

        tm.getTasks().forEach(task -> {System.out.println(task.getName() + " " + task.getStatus());});
        tm.getEpics().forEach(task -> {System.out.println(task.getName() + " " + task.getStatus());});
        tm.getSubTasks().forEach(task -> {System.out.println(task.getName() + " " + task.getStatus());});
        System.out.println();

        tm.deleteById(firstTask.getId());
        tm.deleteById(fitstEpic.getId());

        tm.getTasks().forEach(task -> {System.out.println(task.getName() + " " + task.getStatus());});
        tm.getEpics().forEach(task -> {System.out.println(task.getName() + " " + task.getStatus());});
        tm.getSubTasks().forEach(task -> {System.out.println(task.getName() + " " + task.getStatus());});




    }
}
