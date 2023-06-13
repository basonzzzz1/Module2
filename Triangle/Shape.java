package Triangle;

public abstract class Shape {
    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public abstract double calculateArea();
    public abstract double calculatePerimeter();

    @Override
    public String toString() {
        return "Shape [color = "+color+"]";
    }
}
