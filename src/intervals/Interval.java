package intervals;

public abstract class Interval {

    private double minimum;

    private double maximum;

    private Opening opening;

    public Interval(double minimum, double maximum, Opening opening) {
        this.minimum = minimum;
        this.maximum = maximum;
        this.opening = opening;
    }

    public double midPoint() {
        return (this.getMaximum() + this.getMinimum()) / 2;
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
        return this.getMinimum() == interval.getMaximum();
    }

    protected boolean matchWithBegin(Interval interval) {
        return this.getMaximum() == interval.getMinimum();
    }

    public double getMinimum() {
        return minimum;
    }

    public void setMinimum(double minimum) {
        this.minimum = minimum;
    }

    public double getMaximum() {
        return maximum;
    }

    public void setMaximum(double maximum) {
        this.maximum = maximum;
    }

}
