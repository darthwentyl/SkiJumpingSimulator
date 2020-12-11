
public class SkiJumpingCompetitorGenerator {
    static public CompetitorInfo[] generateCompetitor(int numberOfCompetitors) {
        CompetitorInfo[] competitors = null;
        try {
            CompetitorsWriter writer = new CompetitorsWriter(numberOfCompetitors);
            for (int i = 0; i < numberOfCompetitors; i++) {
                String firstName = new String("firstName_" + i);
                String lastName = new String("lastName_" + i);
                String nationality = new String("nationality_" + i);
                writer.addSingleCompetitors(new CompetitorInfo(firstName, lastName, nationality));
            }
            competitors = writer.getCompetitors();
        } catch (IllegalArgumentException exception) {
            System.err.println(exception);
        }
        return competitors;
    }
}
