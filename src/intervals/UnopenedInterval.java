package intervals;

public class UnopenedInterval extends Interval {

    public UnopenedInterval(double minimum, double maximum, Opening opening) {
        super(minimum, maximum, opening);
    }

    @Override
    public boolean includes(double value) {
        return this.getMinimum() <= value && value <= this.getMaximum();
    }

    @Override
    public boolean intersectsWith(Interval interval) {
        if (this.matchWithEnd(interval)) {
            return interval.getOpening() == Opening.LEFT_OPENED
                    || interval.getOpening() == Opening.UNOPENED;
        }
        if (this.matchWithBegin(interval)) {
            return interval.getOpening() == Opening.RIGHT_OPENED
                    || interval.getOpening() == Opening.UNOPENED;
        }
        return this.includes(interval.getMinimum()) || this.includes(interval.getMaximum());
    }

    @Override
    public boolean includes(Interval interval) {
        return interval.includes(this);
    }

    @Override
    public boolean includes(BothOpenedInterval interval) {
        boolean minimumIncluded = interval.includes(this.getMinimum());
        boolean maximumIncluded = interval.includes(this.getMaximum());
        return (minimumIncluded) && (maximumIncluded);
    }

    @Override
    public boolean includes(UnopenedInterval interval) {
        boolean minimumIncluded = interval.includes(this.getMinimum());
        boolean maximumIncluded = interval.includes(this.getMaximum());
        return (minimumIncluded || interval.getMinimum() == this.getMinimum())
                && (maximumIncluded || interval.getMaximum() == this.getMaximum());
    }

    @Override
    public boolean includes(RightOpenedInterval interval) {
        boolean minimumIncluded = interval.includes(this.getMinimum());
        boolean maximumIncluded = interval.includes(this.getMaximum());
        return (minimumIncluded || interval.getMinimum() == this.getMinimum()) && (maximumIncluded);
    }

    @Override
    public boolean includes(LeftOpenedInterval interval) {
        boolean minimumIncluded = interval.includes(this.getMinimum());
        boolean maximumIncluded = interval.includes(this.getMaximum());
        return (minimumIncluded) && (maximumIncluded || interval.getMaximum() == this.getMaximum());
    }

}
