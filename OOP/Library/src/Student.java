import java.util.GregorianCalendar;

/**
 * @author hudson
 */
public class Student extends Applicant implements Comparable<Object> {
    private String facultyNumber;

    public Student(String name, String facultyNumber) {
        this(new GregorianCalendar(), name, 0.0, facultyNumber);
    }

    public Student(GregorianCalendar date, String name, double score, String facultyNumber) {
        super(date, name, score);

        this.setFacultyNumber(facultyNumber);
    }

    @Override
    public int compareTo(Object obj) {
        if (!(obj instanceof Student)) throw new ClassCastException("Not a Student class");

        if (this.getScore() > ((Student) obj).getScore()) {
            return 1;
        } else if (this.getScore() < ((Student) obj).getScore()) {
            return -1;
        }

        return 0;
    }

    public String getFacultyNumber() {
        return this.facultyNumber;
    }

    public void setFacultyNumber(String facultyNumber) {
        this.facultyNumber = facultyNumber;
    }

    @Override
    public String toString() {
        return super.toString() + ", faculty number:" + this.getFacultyNumber();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Student)) throw new ClassCastException("Not a Student class");

        return (this.getFacultyNumber() == ((Student) obj).getFacultyNumber());
    }
}
