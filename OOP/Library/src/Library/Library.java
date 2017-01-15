package Library;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import Library.Interfaces.IFIle;

/**
 * @author hudson
 *
 */
public class Library implements IFIle {
    private ArrayList<LibraryBook> books;
    private ArrayList<Reader> readers;

    public Library(String readersDB, String booksDB) {
        this.loadReaders(readersDB);

        this.loadBooks(booksDB);
    }

    public void borrowing(int reader, int book) {
        this.books.get(book).setAvailability(false);
        this.books.get(book).setReader(this.readers.get(reader));

        this.readers.get(reader).get(this.books.get(book));
    }

    public void returnBook(int book) {
        Reader bookReader = (Reader) this.books.get(book).getReader();

        for (Reader reader : this.readers) {
            if (reader.equals(bookReader)) {
                reader.ret(this.books.get(book));
            }
        }

        this.books.get(book).setReader(null);
        this.books.get(book).setAvailability(true);
    }

    @Override
    public String toString() {
        String books = "", readers = "";
        for (Reader reader : this.readers) {
            readers += reader.toString();
        }

        for (LibraryBook book : this.books) {
            books += book.toString();
        }

        return "Readers: " + readers + "\nBooks: " + books + "\n"+ super.toString();
    }

    public void printReaders () {
        for (Reader reader : this.readers) {
            Console.printPrompt(reader.toString());
        }
    }

    public void printBooks () {
        for (LibraryBook book : this.books) {
            Console.printPrompt(book.toString());
        }
    }

    public LibraryBook getBookByIndex(int index) {
        return this.books.get(index);
    }

    public Boolean areSameBooks(int first, int second) {
        return this.books.get(first).equals(this.books.get(second));
    }

    public Boolean areSameReader(int first, int second) {
        return this.readers.get(first).equals(this.readers.get(second));
    }

    private void loadReaders(String file) {
        try {
            ArrayList<String> readers = this.load(file);

            for (String reader : readers) {

                String[] readerParams = reader.split(", ");

                String[] dateParams = readerParams[0].split(".");

                int year = Integer.parseInt(dateParams[2]);
                int month = Integer.parseInt(dateParams[2]);
                int dayOfMonth = Integer.parseInt(dateParams[0]);

                GregorianCalendar date = new GregorianCalendar(year, month, dayOfMonth);
                String name = readerParams[1];
                double score = Double.parseDouble(readerParams[2]);
                String facultyNumber = readerParams[3];

                this.readers.add(new Reader(date, name, score, facultyNumber));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadBooks(String file) {
        try {
            ArrayList<String> books = this.load(file);

            for (String book : books) {
                String[] bookParams = book.split(", ");

                String bookName = bookParams[0];
                boolean isAvailable = Boolean.parseBoolean(bookParams[1]);

                this.books.add(new LibraryBook(bookName, isAvailable));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<String> load(String fileData) throws FileNotFoundException, IOException {
        RandomAccessFile file = null;
        ArrayList<String> out = null;
        String line;

        try {
            file = new RandomAccessFile(fileData, "r");

            while ((line = file.readLine()) != null) {
                out.add(line);
            }
        } finally {
            file.close();
        }

        return out;
    }

    @Override
    public void save(String file) {
        // TODO Auto-generated method stub

    }
}
