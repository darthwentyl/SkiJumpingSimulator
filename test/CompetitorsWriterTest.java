import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CompetitorsWriterTest {

    @Test
    void test_create_competitors_list() {
        CompetitorsWriter competitorsWriter = 
                new CompetitorsWriter(CompetitorsWriter.MIN_COMPETITORS + 5);
        CompetitorInfo [] competitors =  competitorsWriter.getCompetitors();
        assertEquals(CompetitorsWriter.MIN_COMPETITORS + 5, competitors.length);
    }

    @Test
    void test_add_single_competitor() {
        CompetitorsWriter competitorsWriter = 
                new CompetitorsWriter(CompetitorsWriter.MIN_COMPETITORS + 5);
        CompetitorInfo competitor = new CompetitorInfo("f1", "l2", "pl");
        competitorsWriter.addSingleCompetitors(competitor);
        CompetitorInfo [] competitors =  competitorsWriter.getCompetitors();
        assertTrue(competitors[0].getFirstName().equals("f1"));
        assertTrue(competitors[0].getLastName().equals("l2"));
        assertTrue(competitors[0].getNationality().equals("pl"));
    }
}
