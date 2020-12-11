
public class SkiJumpingSimulator {

    private static final int FIRST_SERIES_COMPETITORS = 50;
    private static final int SECOND_SERIES_COMPETITORS = 30;
    
    private CompetitorInfo[] _competitors;
    private SkiJumpingJudge[] _judges;
    private SkiJump _skiJump;

/*****************************************************************************
 *                              HELPERS METHODS
 *****************************************************************************/

    private void bubbleSort(int competitorSeriesNumber) {
        int n = competitorSeriesNumber;
        do {
            for(int i = 0; i < n - 1; i++) {
                if(_competitors[i].getPoints() < _competitors[i+1].getPoints()) {
                    CompetitorInfo tmp = _competitors[i+1];
                    _competitors[i+1] = _competitors[i];
                    _competitors[i] = tmp;
                } else if(_competitors[i].getPoints() == _competitors[i+1].getPoints()) {
                    if (_competitors[i].getSumOfDistance() < _competitors[i+1].getSumOfDistance()) {
                        CompetitorInfo tmp = _competitors[i+1];
                        _competitors[i+1] = _competitors[i];
                        _competitors[i] = tmp;
                    }
                }
            }
            n--;
        } while(n > 1);
    }

    private void printResults(String seriesName, int numbersOfCompetitors) {
        System.out.println("++++++++++++++++++ " + seriesName + " ++++++++++++++++++");
        bubbleSort(numbersOfCompetitors);
        for (int i = 0; i < numbersOfCompetitors; ++i) {
            System.out.println(i+1 + ". place:");
            _competitors[i].print();
        }
    }

    private CompetitorInfo[] getCompetitorsToSeries(int numberOfCompetitors) {
        CompetitorsWriter writer = new  CompetitorsWriter(numberOfCompetitors);
        for (int i = numberOfCompetitors - 1; i >= 0; --i) {
            writer.addSingleCompetitors(_competitors[i]);
        }
        return writer.getCompetitors();
    }

    private void generateCompetition() {
        _competitors = SkiJumpingCompetitorGenerator.generateCompetitor(60);

        _judges = new SkiJumpingJudge [5];
        for (int i = 0; i < _judges.length; ++i) {
            _judges[i] = new SkiJumpingJudge();
        }

        _skiJump = new SkiJump(120);
    }

    private void zerosQualificationPoints() {
        for (int i = 0; i < _competitors.length; ++i) {
            _competitors[i].zerosPoints();
        }
    }

/*****************************************************************************
 *                              SIMULATION METHODS
 *****************************************************************************/
    private void qualification() {
        try {
            System.out.println("++++++++++++++++++ QUALIFICATION ++++++++++++++++++");
            SkiJumpSeries series = new SkiJumpSeries(_skiJump, _judges, _competitors, CompetitorInfo.Series.QUALIFICATION);
            series.doSeries();
            printResults("QUALIFICATION RESULTS", _competitors.length);
        } catch (InterruptedException exception) {
            System.err.print(exception);
        }
    }

    private void firstSeries() {
        try {
            zerosQualificationPoints();
            CompetitorInfo[] competitors = getCompetitorsToSeries(FIRST_SERIES_COMPETITORS);
            System.out.println();
            System.out.println("++++++++++++++++++ FIRST SERIES ++++++++++++++++++");
            SkiJumpSeries series = new SkiJumpSeries(_skiJump, _judges, competitors, CompetitorInfo.Series.FIRST);
            series.doSeries();
            printResults("FIRST SERIES RESULTS", FIRST_SERIES_COMPETITORS);
        } catch (InterruptedException exception) {
            System.err.print(exception);
        }
    }

    private void secondSeries() {
        try {
            CompetitorInfo[] competitors = getCompetitorsToSeries(SECOND_SERIES_COMPETITORS);
            System.out.println();
            System.out.println("++++++++++++++++++ SECOND SERIES ++++++++++++++++++");
            SkiJumpSeries series = new SkiJumpSeries(_skiJump, _judges, competitors, CompetitorInfo.Series.SECOND);
            series.doSeries();
            printResults("SECOND SERIES RESULTS", SECOND_SERIES_COMPETITORS);
        } catch (InterruptedException exception) {
            System.err.print(exception);
        }
    }

    public void simulate() {
        try {
            generateCompetition();
            
            qualification();
            firstSeries();
            secondSeries();
        } catch (Exception exception) {
            System.err.println(exception);
        }
    }
}
