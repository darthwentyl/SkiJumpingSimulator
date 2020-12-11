
public class SkiJumpSeries {
    private SkiJump _skiJump;
    private SkiJumpingJudge [] _judges;
    private CompetitorInfo [] _competitors;
    private CompetitorInfo.Series _series;

    SkiJumpSeries(SkiJump skiJump, SkiJumpingJudge[] judges, CompetitorInfo[] competitors, CompetitorInfo.Series series) {
        _skiJump = skiJump;
        _judges = judges;
        _competitors = competitors;
        _series = series;
    }

    public void doSeries() throws InterruptedException {
        SkiJumpDistancePoints distancePoints = new SkiJumpDistancePoints(_skiJump.getConstructionPoint());
        SkiJumpDistance distanceGenerator = new SkiJumpDistance(_skiJump.getConstructionPoint());
        SkiJumpingJudgePoints judgePointsGenerator = new SkiJumpingJudgePoints(_judges);
        double distance = 0;
        for (int i = 0; i < _competitors.length; ++i) {
            distance = distanceGenerator.getDistance();
            _competitors[i].setPoints(distancePoints.getPoints(distance));
            _competitors[i].setPoints(judgePointsGenerator.getPoints());
            _competitors[i].addDistance(distance, _series);
            printResult(_competitors[i], _judges);
            Thread.sleep(1000);
        }
    }

    private static void printResult(CompetitorInfo competitor, SkiJumpingJudge[] judges) {
        System.out.println("Judges points:");
        for (int i = 0; i < judges.length; ++i) {
            System.out.print(judges[i]);
        }
        System.out.println();
        competitor.print();
        System.out.println();
    }
}
