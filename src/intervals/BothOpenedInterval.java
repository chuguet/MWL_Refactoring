package intervals;

public class BothOpenedInterval extends Interval {

    public BothOpenedInterval(double minimum, double maximum, Opening opening) {
        super(minimum, maximum, opening);
    }

    @Override
    public boolean includes(double value) {
        return this.getMinimum() < value && value < this.getMaximum();
    }

    @Override
    public boolean intersectsWith(Interval interval) {
        if (this.getMinimum() == interval.getMaximum()) {
            return false;
        }
        if (this.getMaximum() == interval.getMinimum()) {
            return false;
        }
        return this.includes(interval.getMinimum()) || this.includes(interval.getMaximum());
    }

}
