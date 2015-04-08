package intervals;

public class RightOpenedInterval extends Interval {

    public RightOpenedInterval(double minimum, double maximum, Opening opening) {
        super(minimum, maximum, opening);
    }

    @Override
    public boolean includes(double value) {
        return this.getMinimum() <= value && value < this.getMaximum();
    }

    @Override
    public boolean intersectsWith(Interval interval) {
        if (this.matchWithEnd(interval)) {
            return interval.getOpening() == Opening.LEFT_OPENED
                    || interval.getOpening() == Opening.UNOPENED;
        } else {
            return !this.matchWithBegin(interval)
                    && (this.includes(interval.getMinimum()) || this
                            .includes(interval.getMaximum()));
        }
    }

    @Override
    public boolean includes(Interval interval) {
        return interval.includes(this);
    }

    @Override
    protected boolean includes(BothOpenedInterval interval) {
        boolean minimumIncluded = interval.includes(this.getMinimum());
        boolean maximumIncluded = interval.includes(this.getMaximum());
        return (minimumIncluded) && (maximumIncluded || interval.getMaximum() == this.getMaximum());
    }

    @Override
    protected boolean includes(UnopenedInterval interval) {
        boolean minimumIncluded = interval.includes(this.getMinimum());
        boolean maximumIncluded = interval.includes(this.getMaximum());
        return (minimumIncluded || interval.getMinimum() == this.getMinimum()) && (maximumIncluded);
    }

    @Override
    protected boolean includes(RightOpenedInterval interval) {
        boolean minimumIncluded = interval.includes(this.getMinimum());
        boolean maximumIncluded = interval.includes(this.getMaximum());
        return (minimumIncluded || interval.getMinimum() == this.getMinimum())
                && (maximumIncluded || interval.getMaximum() == this.getMaximum());
    }

    @Override
    protected boolean includes(LeftOpenedInterval interval) {
        boolean minimumIncluded = interval.includes(this.getMinimum());
        boolean maximumIncluded = interval.includes(this.getMaximum());
        return (minimumIncluded) && (maximumIncluded || interval.getMaximum() == this.getMaximum());
    }

}
