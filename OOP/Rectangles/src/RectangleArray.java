
public class RectangleArray {
    private ColorRectangle[] rectangles;

    public RectangleArray(String fileData) {
        String[] rectangles = fileData.split("\n");

        this.rectangles = new ColorRectangle[rectangles.length];

        for (int i = 0; i < rectangles.length; i++) {
            String[] rectangleParams = rectangles[i].split(" ");

            int x1 = Console.readInt(rectangleParams[1]);
            int y1 = Console.readInt(rectangleParams[2]);
            int x2 = Console.readInt(rectangleParams[3]);
            int y2 = Console.readInt(rectangleParams[4]);
            long color = Console.readLong(rectangleParams[5]);

            this.rectangles[i] = new ColorRectangle(x1, y1, x2, y2, color);
        }
    }

    public double calcSumArea() {
        double out = 0;

        for (int i = 0; i < this.rectangles.length; i++) {
            out += this.rectangles[i].calcArea();
        }

        return out;
    }

    public double calcSumPerimeter() {
        double out = 0;

        for (int i = 0; i < this.rectangles.length; i++) {
            // TODO not finished
            out += this.rectangles[i].calcArea();
        }

        return out;
    }
}
