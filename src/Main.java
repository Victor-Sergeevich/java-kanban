public class Main {

    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        System.out.println("Создаю новые задачи:");
        Task task = new Task(0,"Как не отсидеть жо...у на стуле", "Каждый час вставать и разминаться",
                Status.IN_PROGRESS);
        taskManager.addTask(task);
        task = new Task(0, "Использовать технику 'Pomofocus'", "Не забывать включать таймер",
                Status.NEW);
        taskManager.addTask(task);
        Epic epic = new Epic(0,"Изучить ТЗ №4","Изучить все доступные материалы.");
        taskManager.addEpic(epic);
        Subtask subtask = new Subtask(0,"Подготовка", "Прочитать ТЗ", Status.NEW);
        taskManager.addSubtask(subtask);
        subtask = new Subtask(0,"Изучить доп. материалы", "Прочитать сообщения в пачке и " +
                "посмотреть видео", Status.NEW);
        taskManager.addSubtask(subtask);
        epic = new Epic(0,"Выполнить ТЗ №4","Разделить большую задачу на более мелкие");
        taskManager.addEpic(epic);
        subtask = new Subtask(0,"Создать классы", "Создать классы, заполнить поля и создать " +
                "конструкторы", Status.NEW);
        taskManager.addSubtask(subtask);
        System.out.println(taskManager.tasks);
        System.out.println(taskManager.epics);
        System.out.println(taskManager.subtasks);

        System.out.println("Создаю изменения:");
        task = new Task(2, "Использовать технику 'Помидор'", "Не забывать включать таймер",
                Status.IN_PROGRESS);
        taskManager.updateTask(task);
        epic = new Epic(3,"Изучить ТЗ №4","Изучить материалы в ТЗ и пачке");
        taskManager.updateEpic(epic);
        subtask = new Subtask(4,"Подготовка", "Прочитать ТЗ", Status.DONE);
        taskManager.updateSubtask(subtask);
        subtask = new Subtask(5,"Изучить доп. материалы", "Прочитать сообщения в пачке и " +
                "посмотреть видео", Status.DONE);
        taskManager.updateSubtask(subtask);
        epic = new Epic(6,"Выполнить ТЗ №4","Составить список из подзадач");
        taskManager.updateEpic(epic);
        subtask = new Subtask(7,"Создать классы", "Создать классы, заполнить поля и создать " +
                "конструкторы", Status.IN_PROGRESS);
        taskManager.updateSubtask(subtask);
        System.out.println(taskManager.tasks);
        System.out.println(taskManager.epics);
        System.out.println(taskManager.subtasks);

        System.out.println("Вывод всех подзадач эпика по id эпика:");
        System.out.println(taskManager.gettingEpicSubtasks(3));
        System.out.println("Вывод задачи по id:");
        System.out.println(taskManager.gettingById(5));
        System.out.println("Удалить задачу по id:");
        taskManager.deletionById (7);
        System.out.println("Вывод всех задач:");
        System.out.println(taskManager.displayingListOfTasks ()); // Печать всех задач
        System.out.println("Удаление всех задач:");
        taskManager.deletingAllTasks();
        System.out.println(taskManager.displayingListOfTasks ());
    }
}