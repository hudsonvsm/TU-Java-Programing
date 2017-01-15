package Library.Interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public interface IFIle {
    ArrayList<String> load(String file) throws FileNotFoundException, IOException;

    void save();
}
