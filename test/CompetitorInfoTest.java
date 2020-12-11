import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class CompetitorInfoTest {
    CompetitorInfo _info;
    String _firstName;
    String _lastName;
    String _nationality;

    @BeforeEach
    void setUp() throws Exception {
        _firstName = new String("firstName");
        _lastName =  new String("lastName");
        _nationality = new String("nationality");
        _info = new CompetitorInfo(_firstName, _lastName, _nationality);
    }

    @Test
    void test_getters_for_constructor_params() {
        assertTrue(_info.getFirstName().equals(_firstName));
        assertTrue(_info.getLastName().equals(_lastName));
        assertTrue(_info.getNationality().equals(_nationality));
    }

    @Test
    void test_set_get_points() {
        double points =  123;
        _info.setPoints(points);
        assertEquals(points, _info.getPoints());
        _info.setPoints(10);
        assertEquals(points + 10, _info.getPoints());
    }

    @Test
    void test_sum_distance() {
        double qualificationDist = 1;
        double firstSeriesDist = 2;
        double secondSeriesDist = 3;
        _info.addDistance(qualificationDist, CompetitorInfo.Series.QUALIFICATION);
        _info.addDistance(firstSeriesDist, CompetitorInfo.Series.FIRST);
        _info.addDistance(secondSeriesDist, CompetitorInfo.Series.SECOND);
        assertEquals(6, _info.getSumOfDistance());
    }

    @Test
    void test_zeros_points() {
        double qualificationDist = 123;
        _info.addDistance(qualificationDist, CompetitorInfo.Series.QUALIFICATION);
        _info.zerosPoints();
        assertEquals(0, _info.getPoints());
    }
}
