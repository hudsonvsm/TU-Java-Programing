package student.db;

public class ConsoleVisualizer implements StudentDataVisualizer {
    @Override
    public void show(String facultyNumber, String name, String familyName) {
        System.out.println("F.No.# " + facultyNumber + " Name: " + name + " " + familyName);
    }
}
