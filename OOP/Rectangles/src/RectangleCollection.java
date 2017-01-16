import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class RectangleCollection implements IFile {
    private SortedSet<ColorRectangle> rectangles;
    private String fileData;

    public RectangleCollection(String fileData) {
        this.setFileData(fileData);

        this.rectangles = new TreeSet<ColorRectangle>();

        this.load(fileData);
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

    public void printCollection() { // void printColl()
        for (Iterator<ColorRectangle> it = this.rectangles.iterator(); it.hasNext();) {
            Console.printPrompt(it.next().toString());
        }
    }

    @Override
    public void load(String fileData) {
        try {
            RandomAccessFile file = new RandomAccessFile(fileData, "r");

            String line = null;

            while ((line = file.readLine()) != null) {
                String[] rectangleParams = line.split(" ");

                int x1 = Console.readInt(rectangleParams[0]);
                int y1 = Console.readInt(rectangleParams[1]);
                int x2 = Console.readInt(rectangleParams[2]);
                int y2 = Console.readInt(rectangleParams[3]);
                long color = Console.readLong(rectangleParams[4]);

                this.rectangles.add(new ColorRectangle(x1, y1, x2, y2, color));
            }

            file.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save() {
        try {
            RandomAccessFile file = new RandomAccessFile(this.getFileData(), "rw");

            if (this.rectangles.size() > 0) {
            	file.setLength(0);
            }

            for (ColorRectangle rectangle : this.rectangles) {
                file.writeBytes(rectangle.toString() + "\r\n");
            }

            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getFileData() {
        return this.fileData;
    }

    public void setFileData(String fileData) {
        this.fileData = fileData;
    }

    public void addRectangle(ColorRectangle rectangle) {
        this.rectangles.add(rectangle);
    }

    public ColorRectangle calculateUnionCollection() {
        ColorRectangle out = new ColorRectangle();

        for (ColorRectangle rectangle : this.rectangles) {
            out = rectangle.unionRect(out);
        }

        return out;
    }

    public ColorRectangle getMinimumAreaRectangle() {
        return this.rectangles.first();
    }

    public ColorRectangle getMaximumAreaRectangle() {
        return this.rectangles.last();
    }

    public int getNestedRectangles() {
        int out = 0;
        for (Iterator<ColorRectangle> iterator = this.rectangles.iterator(); iterator.hasNext();) {
            ColorRectangle rectangle = iterator.next();

            for (Iterator<ColorRectangle> iterator2 = this.rectangles.iterator(); iterator.hasNext();) {
                ColorRectangle rectangle2 = iterator2.next();

                if (rectangle == rectangle2) {
                    continue;
                }

                if (rectangle.getX1() >= rectangle2.getX1()
                    && rectangle.getX2() <= rectangle2.getX2()
                    && rectangle.getY1() >= rectangle2.getY1()
                    && rectangle.getY2() <= rectangle2.getY2()
                        ) {
                    out++;
                }
            }
        }

        return out;
    }

    public int countRectangles() { // calcSize()
        return this.rectangles.size();
    }

    public List<ColorRectangle> reverseList() {
        ArrayList<ColorRectangle> out = new ArrayList<ColorRectangle>();

        for (ColorRectangle colorRectangle : this.rectangles) {
            out.add(colorRectangle);
        }

        Collections.reverse(out);

        return out;
    }


    public boolean findRect(ColorRectangle toFind) {
        for (ColorRectangle colorRectangle : this.rectangles) {
            if (colorRectangle.equals(toFind)) {
                return true;
            }
        }

        return false;
    }
}
