package student.db;

public class Main {
    public static void main(String[] args) {
        StudentDataVisualizer consoleVisualizer = new ConsoleVisualizer();
        StudentDataLoader studentConsoleLoader = new StudentConsoleLoader();

        Controller.transferData(studentConsoleLoader, consoleVisualizer);

    }
}
