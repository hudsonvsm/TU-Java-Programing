package student.db;

public class Controller {
    public static void main(String[] args) {
        StudentDataVisualizer cv = new ConsoleVisualizer();
        StudentDataLoader sc = new StudentConsoleLoader();
        System.out.println(sc.getFacultyNumber() + " " + sc.getName() + " " +  sc.getFamilyName());

        StudentDataLoader sdb = new StudentDBLoader("12345");
        System.out.println(sdb.getName() + " " + sdb.getFamilyName());
        Controller.transferData(sc, cv);
    }

    public static void transferData(StudentDataLoader from, StudentDataVisualizer to) {
        to.show(from.getFacultyNumber(), from.getName(), from.getFamilyName());
    }
}
