package Library;
import java.util.GregorianCalendar;

/**
 * @author hudson
 */
public class Applicant {
    private String name;
    private double score;
    private GregorianCalendar dateOfAddmition;

    public Applicant(GregorianCalendar birth, String name, double score) {
        this.setDateOfAddmition(birth);
        this.setName(name);
        this.setScore(score);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GregorianCalendar getDateOfAddmition() {
        return this.dateOfAddmition;
    }

    public void setDateOfAddmition(GregorianCalendar dateOfAddmition) {
        this.dateOfAddmition = dateOfAddmition;
    }

    public double getScore() {
        return this.score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Name: " + this.getName() + ", date of addmition: " + this.getDateOfAddmition() + ", score: " + this.getScore();
    }

}
