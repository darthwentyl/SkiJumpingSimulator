
public class SkiJumpDistance {
    static private final double MAX = 0.2; // percent
    static private final double MIN = 0.2; // percent
    
    private double _constructionPoint;

    SkiJumpDistance(double constructionPoint) {
        _constructionPoint= constructionPoint;
    }

    public double getDistance() {
        double minDist = _constructionPoint - _constructionPoint * MIN;
        double maxDist = _constructionPoint + _constructionPoint * MAX;
        double dist = 0.0;
        dist = Math.random() * (maxDist - minDist) + minDist;
        return Math.ceil(dist * 2)/2;
    }
}
