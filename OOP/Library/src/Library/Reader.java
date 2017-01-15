package Library;
import java.util.GregorianCalendar;

import Library.Interfaces.ILibraryBook;
import Library.Interfaces.IReader;

/**
 * @author hudson
 */
public class Reader extends Student implements IReader, Comparable<Object>{

    public Reader(String name, String facultyNumber) {
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
