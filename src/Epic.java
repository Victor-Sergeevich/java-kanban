import java.util.ArrayList;

public class Epic extends Task {
     private ArrayList<Integer> subtasksIds = new ArrayList<>();

    public Epic(int id, String title, String description) {
        super(id, title, description);
    }

    public void addSubtasksIds (int id) {
        subtasksIds.add(id);
    }

    public ArrayList<Integer> getSubtasksIds() {
        return subtasksIds;
    }

    @Override
    public String toString() {
        return "Epic{" +
                "subtasksIds=" + subtasksIds +
                "} " + super.toString();
    }
}
