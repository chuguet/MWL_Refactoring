package intervals;

public abstract class Point {

    private double value;

    public Point(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public abstract boolean menor(Point point);

    public abstract boolean menor(OpenPoint point);

    public abstract boolean menor(ClosePoint point);

    public abstract boolean menorIgual(Point point);

    public abstract boolean menorIgual(OpenPoint point);

    public abstract boolean menorIgual(ClosePoint point);

}
