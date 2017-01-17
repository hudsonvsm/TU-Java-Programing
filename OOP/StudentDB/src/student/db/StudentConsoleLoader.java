package student.db;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentConsoleLoader implements StudentDataLoader {
    // fill data from file loader.
    private List<StudentConsoleLoader> students = new ArrayList<StudentConsoleLoader>();

    private static String facultyNumber;
    private static String firstName;
    private static String familyName;

//    public StudentConsoleLoader(String fNumber, String firstName, String familyName) {
//        StudentConsoleLoader.facultyNumber = fNumber;
//        StudentConsoleLoader.firstName = firstName;
//        StudentConsoleLoader.familyName = familyName;
//    }

    public StudentConsoleLoader()
    {
        StudentConsoleLoader.readFromConsole();
    }

    @Override
    public String getFacultyNumber() {
        return StudentConsoleLoader.facultyNumber;
    }

    @Override
    public String getName() {
        return StudentConsoleLoader.firstName;
    }

    @Override
    public String getFamilyName() {
        return StudentConsoleLoader.familyName;
    }

    private static void readFromConsole()
    {
        // TODO use Console or other class.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter F.Number:");
        StudentConsoleLoader.facultyNumber = scanner.nextLine();

        System.out.println("Enter First Name:");
        StudentConsoleLoader.firstName = scanner.nextLine();

        System.out.println("Enter Last Name:");
        StudentConsoleLoader.familyName = scanner.nextLine();

        scanner.close();
    }
}
