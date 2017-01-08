/**
 * @author hudson
 *
 */
public class ColorRectangle extends Color implements Comparable<Object> {

    private int iX1, iY1, iX2, iY2;

    public ColorRectangle() { }

    public ColorRectangle(int iX1, int iY1, int iX2, int iY2, long c) {
        super(c);
        iX1 = iX1 < iX2 ? iX1 : iX2;
        iY1 = iY1 < iY2 ? iY1 : iY2;
        iX2 = iX1 > iX2 ? iX1 : iX2;
        iY2 = iY1 > iY2 ? iY1 : iY2;
    }

    public int calcArea() {
        return Math.abs(this.iX2 - this.iX1) * Math.abs(this.iY2 - this.iY1);
    }

    public int getX1() {
        return this.iX1;
    }

    public int getX2() {
        return this.iX2;
    }

    public int getY1() {
        return this.iY1;
    }

    public int getY2() {
        return this.iY2;
    }

    public long getColor() {
        return super.getRGBalpha();
    }

    public void setX1(int x) {
        this.iX1 = x;
    }

    public void setX2(int x) {
        this.iX2 = x;
    }

    public void setY1(int x) {
        this.iY1 = x;
    }

    public void setY2(int x) {
        this.iY2 = x;
    }

    @Override
    public int compareTo(Object obj) {
        if (!(obj instanceof ColorRectangle)) throw new ClassCastException("Not a ColorRectangle class");

        if (this.calcArea() < ((ColorRectangle) obj).calcArea()) {
            return -1;
        }
        if (this.calcArea() > ((ColorRectangle) obj).calcArea()) {
            return 1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ColorRectangle)) throw new ClassCastException("Not a ColorRectangle class");

        if (this.calcArea() == ((ColorRectangle) obj).calcArea()
            && this.getColor() == ((ColorRectangle) obj).getColor()) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "area: " + this.calcArea() + " color: " + super.toString();
    }
}
