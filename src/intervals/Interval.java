package intervals;

public abstract class Interval {

    private Point minimum;

    private Point maximum;

    private Opening opening;

    public Interval(Point minimum, Point maximum) {
        this.minimum = minimum;
        this.maximum = maximum;
    }

    public double midPoint() {
        return (this.getMaximum().getValue() + this.getMinimum().getValue()) / 2;
    }

    public abstract boolean includes(double value);

    public abstract boolean includes(Interval interval);

    protected abstract boolean includes(BothOpenedInterval interval);

    protected abstract boolean includes(UnopenedInterval interval);

    protected abstract boolean includes(RightOpenedInterval interval);

    protected abstract boolean includes(LeftOpenedInterval interval);

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

    public Opening getOpening() {
        return opening;
    }

    public void setOpening(Opening opening) {
        this.opening = opening;
    }

    protected boolean matchWithEnd(Interval interval) {
        return this.getMinimum().getValue() == interval.getMaximum().getValue();
    }

    protected boolean matchWithBegin(Interval interval) {
        return this.getMaximum().getValue() == interval.getMinimum().getValue();
    }

    public Point getMinimum() {
        return minimum;
    }

    public void setMinimum(Point minimum) {
        this.minimum = minimum;
    }

    public Point getMaximum() {
        return maximum;
    }

    public void setMaximum(Point maximum) {
        this.maximum = maximum;
    }

}
