package intervals;

public class RightOpenedInterval extends Interval {

    public RightOpenedInterval(double minimum, double maximum, Opening opening) {
        super(minimum, maximum, opening);
    }

    @Override
    public boolean includes(double value) {
        return this.getMinimum() <= value && value < this.getMaximum();
    }

}
