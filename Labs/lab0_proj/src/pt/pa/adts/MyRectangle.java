public class MyRectangle implements Shapeable{
    private double x, y, width, height;
    private String name;

    public MyRectangle(double x, double y, double width, double height, String name) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.name = name;
    }

    public MyRectangle(double width, double height, String name) {
        this.x = 0;
        this.y = 0;
        this.width = width;
        this.height = height;
        this.name = name;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public double getArea() {
        return height * width;
    }

    @Override
    public double getPerimeter() {
        return (height * 2) + (width * 2);
    }

    @Override
    public double getHypotenuse() {
        return Math.sqrt(Math.pow(width, 2) + Math.pow(height, 2));
    }

    @Override
    public boolean isPerfect() {
        double sizemin = Math.min(width, height);
        double sizemax = Math.max(width, height);
        return sizemin >= (sizemax/2)? true : false;
    }

    @Override
    public String toString() {
        return "MyRectangle{" +
                "name='" + name + "', " +
                "x=" + x +", " +
                "y=" + y +", " +
                "width=" + width +", " +
                "height=" + height +", " +
                "area=" + getArea() +", " +
                "perimeter=" + getPerimeter() +", " +
                "hypotenuse=" + getHypotenuse() +",\n" +
                "isPerfect= " + (isPerfect()? "YES" : "NO") + "}\n";
    }
}
