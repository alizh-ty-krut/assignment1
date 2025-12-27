public class Rectangle {
    private double width;
    private double height;
    private int id;
    private static int idGen = 0;

    public Rectangle() {
        this.width = 1.0;
        this.height = 1.0;

        this.id = idGen++;
    }

    public Rectangle(double width, double height) {
        this();

        setWidth(width);
        setHeight(height);
    }

    public void setWidth(double width) {
        if (width > 0) {
            this.width = width;
        } else {
            throw new IllegalArgumentException("Width of a rectangle must be positive");
        }
    }

    public void setHeight(double height) {
        if (height > 0) {
            this.height = height;
        } else {
            throw new IllegalArgumentException("Height of a rectangle must be positive");
        }
    }

    public double getWidth() {
        return this.width;
    }

    public double getHeight() {
        return this.height;
    }

    public double area() {
        return this.width * this.height;
    }

    public double perimeter() {
        return 2 * (this.width + this.height);
    }

    @Override
    public String toString() {
        return "Width = " + this.width + "\nHeight = " + this.height + "\nID = " + this.id;
    }
}
