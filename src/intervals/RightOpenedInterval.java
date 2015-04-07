package intervals;

public class RightOpenedInterval extends Interval {

    public RightOpenedInterval(Point point, Opening opening) {
        super(point, opening);
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
        boolean minimumIncluded = this.includes(interval.getMinimum());
        boolean maximumIncluded = this.includes(interval.getMaximum());
        switch (interval.getOpening()) {
        case BOTH_OPENED:
            return (minimumIncluded || this.getMinimum() == interval.getMinimum())
                    && (maximumIncluded || this.getMaximum() == interval.getMaximum());
        case LEFT_OPENED:
            return (minimumIncluded || this.getMinimum() == interval.getMinimum())
                    && (maximumIncluded);
        case RIGHT_OPENED:
            return (minimumIncluded || this.getMinimum() == interval.getMinimum())
                    && (maximumIncluded || this.getMaximum() == interval.getMaximum());
        case UNOPENED:
            return (minimumIncluded || this.getMinimum() == interval.getMinimum())
                    && (maximumIncluded);
        default:
            assert false;
            return false;
        }
    }

}
