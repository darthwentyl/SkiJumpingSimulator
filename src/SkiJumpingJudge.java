
public class SkiJumpingJudge {
    static private final double MIN_STYLE_POINTS = 10;
    static private final double MAX_STYLE_POINTS = 20;

    private double _stylePoints;

    public double getStylePoints() {
        _stylePoints = Math.random() * (MAX_STYLE_POINTS - MIN_STYLE_POINTS) + MIN_STYLE_POINTS;
        _stylePoints = Math.ceil(_stylePoints * 2) / 2;
        return _stylePoints;
    }

    public String toString() {
        return "[ " + _stylePoints + " ]";
    }
}
