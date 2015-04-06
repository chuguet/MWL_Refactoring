package intervals;

public class IntervalFactory {

    public static Interval getInterval(double minimum, double maximum, Opening opening) {
        switch (opening) {
        case BOTH_OPENED:
            return new BothOpenedInterval(new Point(minimum, maximum), opening);
        case LEFT_OPENED:
            return new LeftOpenedInterval(new Point(minimum, maximum), opening);
        case RIGHT_OPENED:
            return new RightOpenedInterval(new Point(minimum, maximum), opening);
        case UNOPENED:
            return new UnopenedInterval(new Point(minimum, maximum), opening);
        default:
            throw new IllegalArgumentException("Unexpected type interval");
        }
    }
}
