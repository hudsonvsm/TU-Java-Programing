package student.db;

public class ConsoleVisualizer implements StudentDataVisualizer {
    @Override
    public void show(String facultyNumber, String name, String familyName) {
        Console.printPrompt(facultyNumber);
        Console.printPrompt(name);
        Console.printPrompt(familyName);
    }
}
