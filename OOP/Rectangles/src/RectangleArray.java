import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class RectangleArray {
    private ArrayList<ColorRectangle> rectangles;
    private RandomAccessFile file;

    public RectangleArray(String fileData) throws IOException, FileNotFoundException {
        try {
            this.rectangles = new ArrayList<ColorRectangle>();

            this.file = new RandomAccessFile(fileData, "r");

            String line;

            while ((line = this.file.readLine()) != null) {
                String[] rectangleParams = line.split(" ");

                int x1 = Console.readInt(rectangleParams[0]);
                int y1 = Console.readInt(rectangleParams[1]);
                int x2 = Console.readInt(rectangleParams[2]);
                int y2 = Console.readInt(rectangleParams[3]);
                long color = Console.readLong(rectangleParams[4]);

                this.rectangles.add(new ColorRectangle(x1, y1, x2, y2, color));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            this.file.close();
        }
    }

    public double calcSumArea() {
        double out = 0;

        for (ColorRectangle colorRectangle : this.rectangles) {
            out += colorRectangle.calcArea();
        }

        return out;
    }

    public double calcSumPerimeter() {
        double out = 0;

        for (ColorRectangle colorRectangle : this.rectangles) {
            out += colorRectangle.calcPerimeter();
        }

        return out;
    }

    public void printCollection() {
        for (ColorRectangle colorRectangle : this.rectangles) {
            Console.printPrompt(colorRectangle.toString());
        }
    }
}
