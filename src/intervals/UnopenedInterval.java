package intervals;

public class UnopenedInterval extends Interval {

    public UnopenedInterval(double minimum, double maximum, Opening opening) {
        super(minimum, maximum, opening);
    }

    @Override
    public boolean includes(double value) {
        return this.getMinimum() <= value && value <= this.getMaximum();
    }

}
