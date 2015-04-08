package intervals;

public class IntervalFactory {

    public static Interval getInterval(double minimum, double maximum, Opening opening) {
        switch (opening) {
        case BOTH_OPENED:
            return new BothOpenedInterval(new OpenPoint(minimum), new OpenPoint(maximum), opening);
        case LEFT_OPENED:
            return new LeftOpenedInterval(new OpenPoint(minimum), new ClosePoint(maximum), opening);
        case RIGHT_OPENED:
            return new RightOpenedInterval(new ClosePoint(minimum), new OpenPoint(maximum), opening);
        case UNOPENED:
            return new UnopenedInterval(new ClosePoint(minimum), new ClosePoint(maximum), opening);
        default:
            throw new IllegalArgumentException("Unexpected type interval");
        }
    }
}
