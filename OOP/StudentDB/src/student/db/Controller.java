package student.db;

public class Controller {
    public static void transferData(StudentDataLoader from, StudentDataVisualizer to) {
        to.show(from.getFacultyNumber(), from.getFirstName(), from.getFamilyName());
    }
}
