package student.db;

public class StudentConsoleLoader implements StudentDataLoader {
    private String facultyNumberPrompt = "Faculty number: ";
    private String firstNamePrompt = "First name: ";
    private String familyNamePrompt = "Family name: ";
    private String facultyNumber;
    private String firstName;
    private String familyName;

    public StudentConsoleLoader (){
        this.facultyNumber = Console.readLine(this.facultyNumberPrompt);
        this.firstName = Console.readLine(this.firstNamePrompt);
        this.familyName = Console.readLine(this.familyNamePrompt);
    }

    @Override
    public String getFacultyNumber() {
        return this.facultyNumber;
    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public String getFamilyName() {
        return this.familyName;
    }

}
