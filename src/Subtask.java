public class Subtask extends Task {
    private int epicId;

    public Subtask(String name, String description) {
        super(name, description);
    }

    public int getEpicId() {
        return epicId;
    }
}
