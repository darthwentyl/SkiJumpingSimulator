
public class SkiJumpDistancePoints {
    private double _constructionPoint;

    SkiJumpDistancePoints(double constructionPoint) {
        if (constructionPoint < 1) {
            throw new IllegalArgumentException("The construction point should be bigger than 1. Currently is " + constructionPoint);
        }
        _constructionPoint = constructionPoint;
    }

    public double getPoints(double distance) {
        if (distance < 0) {
            throw new IllegalArgumentException("The distance should be bigger than 0. Currently is " + distance);
        }
        double points = _constructionPoint;
        if (distance > _constructionPoint) {
            points += distance - _constructionPoint;
        } else {
            points -= _constructionPoint - distance;
        }
        return points;
    }
}
