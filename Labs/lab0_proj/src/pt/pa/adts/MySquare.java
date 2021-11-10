public class MySquare extends MyRectangle{

    public MySquare(double x, double y, double edge, String name) {
        super(x, y, edge, edge, name);
    }

    public MySquare(double edge, String name) {
        super(edge, edge, name);
    }

    @Override
    public boolean isPerfect() {
        double hypotenuse = getHypotenuse();

        return hypotenuse <= 0.00000001;
    }

    @Override
    public String toString() {
        return "MySquares{" +
                "name='" + getName() + "', " +
                "x=" + getX() +", " +
                "y=" + getY() +", " +
                "edge=" + getWidth() +", " +
                "area=" + getArea() +", " +
                "perimeter=" + getPerimeter() +", " +
                "hypotenuse=" + getHypotenuse() +",\n" +
                "isPerfect= " + (this.isPerfect()? "YES" : "NO") + "}\n";
    }
}
