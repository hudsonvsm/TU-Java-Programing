import java.util.GregorianCalendar;

/**
 * @author hudson
 */
public class Reader extends Student implements IReader, Comparable<Object>{

    public Reader(String name,String facultyNumber) {
        super(name, facultyNumber);
    }

    public Reader(GregorianCalendar date, String name, double score, String facultyNumber) {
        super(date, name, score, facultyNumber);
    }

    @Override
    public void get(ILibraryBook lb) {
        // TODO Auto-generated method stub

    }

    @Override
    public void ret(ILibraryBook lb) {
        // TODO Auto-generated method stub

    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
