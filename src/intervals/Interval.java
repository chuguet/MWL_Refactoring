package intervals;

public abstract class Interval {

    private Point point;

    private Opening opening;

    public Interval(Point point, Opening opening) {
        this.point = point;
        this.opening = opening;
    }

    public double midPoint() {
        return (this.getMaximum() + this.getMinimum()) / 2;
    }

    public abstract boolean includes(double value);

    public abstract boolean includes(Interval interval);

    public abstract boolean includes(BothOpenedInterval interval);

    public abstract boolean includes(UnopenedInterval interval);

    public abstract boolean includes(RightOpenedInterval interval);

    public abstract boolean includes(LeftOpenedInterval interval);

    public abstract boolean intersectsWith(Interval interval);

    @Override
    public String toString() {
        // TODO
        return null;
    }

    @Override
    public boolean equals(Object object) {
        // TODO
        return false;
    }

    public double getMinimum() {
        return this.getPoint().getX();
    }

    public double getMaximum() {
        return this.getPoint().getY();
    }

    public Opening getOpening() {
        return opening;
    }

    public void setOpening(Opening opening) {
        this.opening = opening;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    protected boolean matchWithEnd(Interval interval) {
        return this.getMinimum() == interval.getMaximum();
    }

    protected boolean matchWithBegin(Interval interval) {
        return this.getMaximum() == interval.getMinimum();
    }

}
