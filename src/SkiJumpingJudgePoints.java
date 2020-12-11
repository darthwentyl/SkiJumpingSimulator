
public class SkiJumpingJudgePoints {
    private SkiJumpingJudge[] _judges;

    SkiJumpingJudgePoints(SkiJumpingJudge[] judges) {
        _judges = judges;
    }

    private void bubbleSort(double [] judgePoints) {
        int n = judgePoints.length;
        do {
            for(int i = 0; i < n - 1; i++) {
                if(judgePoints[i] > judgePoints[i+1]) {
                    double tmp = judgePoints[i+1];
                    judgePoints[i+1] = judgePoints[i];
                    judgePoints[i] = tmp;
                }
            }
            n--;
        } while(n > 1);
    }

    public double getPoints() {
        double points = 0;
        double [] judgesPoints = new double [_judges.length];
        for (int i = 0; i < _judges.length; i++) {
            judgesPoints[i] = _judges[i].getStylePoints();
            points += judgesPoints[i];
        }
        bubbleSort(judgesPoints);
        return points - judgesPoints[0] - judgesPoints[_judges.length - 1];
    }
}
