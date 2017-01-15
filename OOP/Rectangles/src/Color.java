/**
 * @author hudson
 *
 */
public class Color implements Comparable<Object> {
    /**
     *    Alpha      Red      Green     Blue
     * [00000000][00000000][00000000][00000000]
     *  32    25  24    16  15     8  7      0
     *                битове
     * Alpha е канала за прозрачност
     */

    public static final int COLOR_BIT_MASK = 255;

    private long red,
                 green,
                 blue,
                 rgba;

    public Color() {
        this(0);
    }

    public Color(long rgba) {
        this.setrgbalpha(rgba);
    }

    public long getRed() {
        return this.red;
    }

    public void setRed(long red) {
        this.red = red;

        this.colors2rgb();
    }

    public long getGreen() {
        return this.green;
    }

    public void setGreen(long green) {
        this.green = green;

        this.colors2rgb();
    }

    public long getBlue() {
        return this.blue;
    }

    public void setBlue(long blue) {
        this.blue = blue;

        this.colors2rgb();
    }

    public long getRGBalpha() {
        return this.rgba;
    }

    public void setrgbalpha(long rgba) {
        this.rgba = rgba;

        this.rgbaToColors();
    }

    private void rgbaToColors() {
        this.red = (this.rgba >>> 16) & Color.COLOR_BIT_MASK;
        this.green = (this.rgba >>> 8) & Color.COLOR_BIT_MASK;
        this.blue = (this.rgba) & Color.COLOR_BIT_MASK;
    }

    private void colors2rgb() {
        this.rgba = (this.red << 16) | (this.green << 8) | (this.blue);
    }

    @Override
    public String toString() {
        return "(Red: " + this.red + ", Green: " + this.green + ", Blue: " + this.blue + ", Alpha: " + this.rgba + ")" + super.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Color)) throw new ClassCastException("Not a Color class");

        return (this.rgba == ((Color) obj).rgba);
    }

    @Override
    public int compareTo(Object obj) {
        if (!(obj instanceof Color)) throw new ClassCastException("Not a Color class");

        if (this.rgba > ((Color) obj).rgba) {
            return 1;
        } else if (this.rgba < ((Color) obj).rgba) {
            return -1;
        }

        return 0;
    }

}
