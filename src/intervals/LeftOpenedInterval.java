package intervals;

public class LeftOpenedInterval extends Interval {

    public LeftOpenedInterval(Point point, Opening opening) {
        super(point, opening);
    }

    @Override
    public boolean includes(double value) {
        return this.getMinimum() < value && value <= this.getMaximum();
    }

    @Override
    public boolean intersectsWith(Interval interval) {
        if (this.getMaximum() == interval.getMinimum()) {
            return interval.getOpening() == Opening.RIGHT_OPENED
                    || interval.getOpening() == Opening.UNOPENED;
        } else {
            return !this.matchWithEnd(interval)
                    && (this.includes(interval.getMinimum()) || this
                            .includes(interval.getMaximum()));
        }
    }

    @Override
    public boolean includes(Interval interval) {
        boolean minimumIncluded = this.includes(interval.getMinimum());
        boolean maximumIncluded = this.includes(interval.getMaximum());
        switch (interval.getOpening()) {
        case BOTH_OPENED:
            return (minimumIncluded || this.getMinimum() == interval.getMinimum())
                    && (maximumIncluded || this.getMaximum() == interval.getMaximum());
        case LEFT_OPENED:
            return (minimumIncluded || this.getMinimum() == interval.getMinimum())
                    && (maximumIncluded || this.getMaximum() == interval.getMaximum());
        case RIGHT_OPENED:
            return (minimumIncluded)
                    && (maximumIncluded || this.getMaximum() == interval.getMaximum());
        case UNOPENED:
            return (minimumIncluded)
                    && (maximumIncluded || this.getMaximum() == interval.getMaximum());
        default:
            assert false;
            return false;
        }
    }

}
