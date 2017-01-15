package Library;
import Library.Interfaces.ILibraryBook;
import Library.Interfaces.IReader;

/**
 * @author hudson
 */
public class LibraryBook implements ILibraryBook, Comparable<Object> {

    private IReader reader;
    private String bookName;
    private boolean isAvailable;

    public LibraryBook(String bookName, boolean isAvailable) {
        this.setBookName(bookName);
        this.setAvailability(isAvailable);
    }

    public IReader getReader() {
        return this.reader;
    }

    public void setReader(IReader reader) {
        this.reader = reader;
    }

    public String getBookName() {
        return this.bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public boolean isAvailable() {
        return this.isAvailable;
    }

    public void setAvailability(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    @Override
    public int compareTo(Object obj) {
        if (!(obj instanceof LibraryBook)) throw new ClassCastException("Not a LibraryBook class");

        return this.getBookName().compareTo(((LibraryBook) obj).getBookName());
    }

    @Override
    public void get(IReader reader) {
        this.setReader(reader);
        this.setAvailability(false);
    }

    @Override
    public void ret() {
        this.setReader(null);
        this.setAvailability(true);
    }

    @Override
    public String toString() {
        String reader = (this.getReader() == null) ? "" : ", reader: " + this.getReader().toString();

        return "Book name: "+ this.getBookName() +", availability: " + String.valueOf(this.isAvailable) + reader;
    }
}
