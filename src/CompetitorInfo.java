
public class CompetitorInfo {
    private String _firstName;
    private String _lastName;
    private String _nationality;
    private double _points;
    private double[] _distances;

    public enum Series {
        QUALIFICATION,
        FIRST,
        SECOND
    }

    public CompetitorInfo(String firstName, String lastName, String nationality) {
        _firstName = firstName;
        _lastName = lastName;
        _nationality = nationality;
        _points = 0;
        _distances = new double [3];
    }

    public void setPoints(double points) {
        _points += points;
    }

    public void zerosPoints() {
        _points = 0;
    }

    public String getFirstName() {
        return _firstName;
    }

    public String getLastName() {
        return _lastName;
    }

    public String getNationality() {
        return _nationality;
    }

    public double getPoints() {
        return _points;
    }

    public void addDistance(double distance, Series series) {
        _distances[series.ordinal()] = distance;
    }

    public double getSumOfDistance() {
        double sumOfDistance = 0;
        for (int i = 0; i < _distances.length; ++i) {
            sumOfDistance += _distances[i];
        }
        return sumOfDistance;
    }

    public void print() {
        System.out.println("Competitor: " + _firstName + " " + _lastName + " " + _nationality);
        for (int i = 0; i < _distances.length; ++i) {
            System.out.print(_distances[i] + "[m] ");
        }
        System.out.println("points: " + _points);
    }
}
