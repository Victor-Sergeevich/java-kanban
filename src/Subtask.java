public class Subtask extends Task {
     private int epicId;

    public Subtask(int id, String title, String description, Status status) {
        super(id, title, description, status);
        ///this.epicId = epicId;///Удалить
    }

    public int getEpicId() {
        return epicId;
    }

    public void setEpicId(int epicId) {
        this.epicId = epicId;
    }

    @Override
    public String toString() {
        return "Subtask{" +
                "epicId=" + epicId +
                "} " + super.toString();
    }
}