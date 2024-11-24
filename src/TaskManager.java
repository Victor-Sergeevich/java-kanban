import java.util.ArrayList;
import java.util.HashMap;

public class TaskManager {
    HashMap<Integer, Task> tasks = new HashMap<>();
    HashMap<Integer, Epic> epics = new HashMap<>();
    HashMap<Integer, Subtask> subtasks = new HashMap<>();
    int nextId = 1;
    int epicId;

    public void addTask(Task task) { // Создание новой задачи
        task.setId(nextId++);
        tasks.put(task.getId(), task);
    }

    public void addEpic(Epic epic) { // Создание нового эпика
        epic.setId(nextId++);
        epicId = epic.getId();
        epics.put(epic.getId(), epic);
    }

    public void addSubtask(Subtask subtask) { // Создание новой подзадачи
        subtask.setId(nextId++);
        subtask.setEpicId(epicId);
        subtasks.put(subtask.getId(), subtask);
        Epic epic = epics.get(subtask.getEpicId());
        epic.addSubtasksIds(subtask.getId());
        changeEpicStatus(epic);
    }

    public void changeEpicStatus(Epic epic) { // Присвоение эпику нового статуса
        Status epicStatus = Status.NEW;
        int counter = 0;
        for (Integer subtasksId : epic.getSubtasksIds()) {
            Subtask aSubtask = subtasks.get(subtasksId);
            switch (aSubtask.getStatus()) {
                case IN_PROGRESS:
                    epicStatus = Status.IN_PROGRESS;
                    break;
                case DONE:
                    counter++;
                    epicStatus = Status.IN_PROGRESS;
                    break;
            }
        }
        if (counter == epic.getSubtasksIds().size() && epic.getSubtasksIds().size() != 0) {
            epicStatus = Status.DONE;
        }
        epic.setStatus(epicStatus);
    }

    public void updateTask(Task task) { // Внесение изменений в задачу
        tasks.put(task.getId(), task);
    }

    public void updateEpic(Epic epic) { // Внесение изменений в эпик
        Epic epicOld = epics.get(epic.getId());
        for (int a : epicOld.getSubtasksIds()) {
            epic.addSubtasksIds(a);
        }
        epics.put(epic.getId(), epic);
    }

    public void updateSubtask(Subtask subtask) { // Внесение изменений в подзадачу
        Subtask subtaskOld = subtasks.get(subtask.getId());
        subtask.setEpicId(subtaskOld.getEpicId());
        subtasks.put(subtask.getId(), subtask);
        Epic epic = epics.get(subtask.getEpicId());
        changeEpicStatus(epic);
    }

    public HashMap<Integer, Task> displayingListOfTasks() { // Вывод всех задач
        HashMap<Integer, Task> allTasks = new HashMap<>();
        allTasks.putAll(tasks);
        allTasks.putAll(epics);
        allTasks.putAll(subtasks);
        return allTasks;
    }

    public void deletingAllTasks() { // Удаление всех задач
        tasks.clear();
        epics.clear();
        subtasks.clear();
    }

    public String gettingById(int id) { // Вывод задачи по ID
        String oneTask = "";
        if (tasks.containsKey(id)) {
            oneTask = String.valueOf(tasks.get(id));
        } else if (epics.containsKey(id)) {
            oneTask = String.valueOf(epics.get(id));
        } else if (subtasks.containsKey(id)) {
            oneTask = String.valueOf(subtasks.get(id));
        }
        return oneTask;
    }

    public void deletionById(Integer id) { // Удаление задачи по ID
        if (tasks.containsKey(id)) {
            tasks.remove(id);
        } else if (epics.containsKey(id)) {
            epics.remove(id);
        } else if (subtasks.containsKey(id)) {
            Epic epic = epics.get(subtasks.get(id).getEpicId());
            subtasks.remove(id);
            epic.getSubtasksIds().remove(id);
            changeEpicStatus(epic);
        }
    }

    public ArrayList gettingEpicSubtasks(Integer id) { // Вывод всех подзадач по ID эпика
        ArrayList<Subtask> subtasksEpic = new ArrayList<>();
        for (Integer a : epics.get(id).getSubtasksIds()) {
            subtasksEpic.add(subtasks.get(a));
        }
        return subtasksEpic;
    }
}