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

    public int calcPerimeter() {
        return 2 * Math.abs(this.iX2 - this.iX1) + 2 * Math.abs(this.iY2 - this.iY1);
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

    public void translateX(int iPoints) {
        this.iX1 += iPoints;
        this.iX2 += iPoints;
    }

    public void translateY(int iPoints) {
        this.iY2 += iPoints;
        this.iY2 += iPoints;
    }

    public void translateXY(int iPoints){
        this.translateX(iPoints);
        this.translateY(iPoints);
    }

    public boolean isInside(int ptX, int ptY ) {
        return (this.iX2 >= ptX
                && this.iX1 <= ptX
                && this.iY2 >= ptY
                && this.iY2 <= ptY)
            ? true
            : false;
    }

    public ColorRectangle unionRect(ColorRectangle r) {
        int x1 = this.iX1 > r.iX1 ? r.iX1 : this.iX1;
        int x2 = this.iX2 < r.iX2 ? r.iX2 : this.iX2;
        int y1 = this.iY1 > r.iY1 ? r.iY1 : this.iY1;
        int y2 = this.iY2 < r.iY2 ? r.iY2 : this.iY2;

        return new ColorRectangle(x1, x2, y1, y2, 0);
    }

    public ColorRectangle intersectionRect(ColorRectangle r) {
        int x1 = this.iX1 < r.iX1 ? r.iX1 : this.iX1;
        int x2 = this.iX2 > r.iX2 ? r.iX2 : this.iX2;
        int y1 = this.iY1 < r.iY1 ? r.iY1 : this.iY1;
        int y2 = this.iY2 > r.iY2 ? r.iY2 : this.iY2;

        if (x2 <= x1 || y2 <= y1) {
            return new ColorRectangle();
        }

        return new ColorRectangle(x1, x2, y1, y2, 0);
    }

    @Override
    public String toString() {
        String coords = ", x1: " + this.iX1 + ", x2: " + this.iX2 + ", y1: " + this.iY1 + ", y2: " + this.iY2;

        return "area: " + this.calcArea() + coords + ", color: " + super.toString();
    }
}
