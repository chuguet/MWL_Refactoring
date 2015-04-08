package intervals;

public class OpenPoint extends Point {

    public OpenPoint(double value) {
        super(value);
    }

    @Override
    public boolean menor(Point point) {
        return point.menor(this);
    }

    @Override
    public boolean menorIgual(Point point) {
        return point.menorIgual(this);
    }

    @Override
    public boolean menor(OpenPoint point) {
        return point.getValue() < this.getValue();
    }

    @Override
    public boolean menor(ClosePoint point) {
        return point.getValue() < this.getValue();
    }

    @Override
    public boolean menorIgual(OpenPoint point) {
        return point.getValue() <= this.getValue();
    }

    @Override
    public boolean menorIgual(ClosePoint point) {
        return point.getValue() <= this.getValue();
    }

}
