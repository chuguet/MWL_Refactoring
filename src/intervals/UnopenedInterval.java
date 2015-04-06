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
        if (this.getMinimum() == interval.getMaximum()) {
            return interval.getOpening() == Opening.LEFT_OPENED
                    || interval.getOpening() == Opening.UNOPENED;
        }
        if (this.getMaximum() == interval.getMinimum()) {
            return interval.getOpening() == Opening.RIGHT_OPENED
                    || interval.getOpening() == Opening.UNOPENED;
        }
        return this.includes(interval.getMinimum()) || this.includes(interval.getMaximum());
    }

}
