
public class SkiJump {
    private double _contructionPoint; // [m]

    SkiJump(int constructionPoint) {
        if (constructionPoint < 1) {
            throw new IllegalArgumentException("The construction point should be bigger than 1. Currently is " + constructionPoint);
        }
        _contructionPoint = constructionPoint;
    }

    public double getConstructionPoint() {
        return _contructionPoint;
    }
}
