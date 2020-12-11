import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class SkiJumpDistancePointsTest {
    static final double CONSTRUCTION_POINT = 120;
    SkiJumpDistancePoints _skiJumpDistancePoints;

    @BeforeEach
    void setUp() throws Exception {
        _skiJumpDistancePoints = new SkiJumpDistancePoints(CONSTRUCTION_POINT);
    }

    @Test
    void test_less_than_min() {
        assertThrows(IllegalArgumentException.class, 
                () -> {
                        SkiJumpDistancePoints skiJumpDistancePointsTmp = new SkiJumpDistancePoints(-1);
                    }
                );
    }

    @Test
    void test_less_than_0() {
        assertThrows(IllegalArgumentException.class, 
                () -> {
                        _skiJumpDistancePoints.getPoints(-1);
                    }
                );
    }

    @Test
    void test_equal_construction_point() {
        assertEquals(CONSTRUCTION_POINT, _skiJumpDistancePoints.getPoints(CONSTRUCTION_POINT));
    }

    @Test
    void test_less_construction_point() {
        double lessBy = 10;
        assertEquals(CONSTRUCTION_POINT - lessBy, _skiJumpDistancePoints.getPoints(CONSTRUCTION_POINT  - lessBy));
    }

    @Test
    void test_more_construction_point() {
        double moreBy = 10;
        assertEquals(CONSTRUCTION_POINT + moreBy, _skiJumpDistancePoints.getPoints(CONSTRUCTION_POINT + moreBy));
    }
}
