package intervals;

public class IntervalFactory {

    public static Interval getInterval(double minimum, double maximum, Opening opening) {
        switch (opening) {
        case BOTH_OPENED:
            return new BothOpenedInterval(new OpenPoint(minimum), new OpenPoint(maximum));
        case LEFT_OPENED:
            return new LeftOpenedInterval(new OpenPoint(minimum), new ClosePoint(maximum));
        case RIGHT_OPENED:
            return new RightOpenedInterval(new ClosePoint(minimum), new OpenPoint(maximum));
        case UNOPENED:
            return new UnopenedInterval(new ClosePoint(minimum), new ClosePoint(maximum));
        default:
            throw new IllegalArgumentException("Unexpected type interval");
        }
    }
}
