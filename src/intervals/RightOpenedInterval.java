package intervals;

public class RightOpenedInterval extends Interval {

    public RightOpenedInterval(Point minimum, Point maximum, Opening opening) {
        super(minimum, maximum, opening);
    }

    @Override
    public boolean includes(double value) {
        Point point = new ClosePoint(value);
        return this.getMinimum().menorIgual(point) && point.menor(this.getMaximum());
    }

    @Override
    public boolean intersectsWith(Interval interval) {
        if (this.matchWithEnd(interval)) {
            return interval.getOpening() == Opening.LEFT_OPENED
                    || interval.getOpening() == Opening.UNOPENED;
        } else {
            return !this.matchWithBegin(interval)
                    && (this.includes(interval.getMinimum().getValue()) || this.includes(interval
                            .getMaximum().getValue()));
        }
    }

    @Override
    public boolean includes(Interval interval) {
        return interval.includes(this);
    }

    @Override
    protected boolean includes(BothOpenedInterval interval) {
        boolean minimumIncluded = interval.includes(this.getMinimum().getValue());
        boolean maximumIncluded = interval.includes(this.getMaximum().getValue());
        return (minimumIncluded)
                && (maximumIncluded || interval.getMaximum().getValue() == this.getMaximum()
                        .getValue());
    }

    @Override
    protected boolean includes(UnopenedInterval interval) {
        boolean minimumIncluded = interval.includes(this.getMinimum().getValue());
        boolean maximumIncluded = interval.includes(this.getMaximum().getValue());
        return (minimumIncluded || interval.getMinimum().getValue() == this.getMinimum().getValue())
                && (maximumIncluded);
    }

    @Override
    protected boolean includes(RightOpenedInterval interval) {
        boolean minimumIncluded = interval.includes(this.getMinimum().getValue());
        boolean maximumIncluded = interval.includes(this.getMaximum().getValue());
        return (minimumIncluded || interval.getMinimum().getValue() == this.getMinimum().getValue())
                && (maximumIncluded || interval.getMaximum().getValue() == this.getMaximum()
                        .getValue());
    }

    @Override
    protected boolean includes(LeftOpenedInterval interval) {
        boolean minimumIncluded = interval.includes(this.getMinimum().getValue());
        boolean maximumIncluded = interval.includes(this.getMaximum().getValue());
        return (minimumIncluded)
                && (maximumIncluded || interval.getMaximum().getValue() == this.getMaximum()
                        .getValue());
    }

}
