
public class CompetitorsWriter {
    public static final int MIN_COMPETITORS = 50;
    private CompetitorInfo [] _competitors;
    private int _curNumOfRegCompetitors;

    CompetitorsWriter(int numberOfCompetitors) {
        _competitors = new CompetitorInfo[numberOfCompetitors];
        _curNumOfRegCompetitors = 0;
    }

    public CompetitorInfo [] getCompetitors() {
        return  _competitors;
    }

    public void addSingleCompetitors(CompetitorInfo competitor) {
        if (_curNumOfRegCompetitors == _competitors.length) {
            throw new RuntimeException("The list of competitors is filled. You cannot write more!");
        }
        _competitors[_curNumOfRegCompetitors] = competitor;
        _curNumOfRegCompetitors++;
    }
}
