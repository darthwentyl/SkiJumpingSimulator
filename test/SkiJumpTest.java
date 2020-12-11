import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SkiJumpTest {

    @Test
    void test_less_than_min() {
        assertThrows(IllegalArgumentException.class, 
                () -> {
                        SkiJump skiJump = new SkiJump(-1);
                        skiJump.getConstructionPoint();
                    }
                );
    }

    @Test
    void test_correct_construction_point() {
        SkiJump skiJump = new SkiJump(120);
        assertEquals(120, skiJump.getConstructionPoint());
    }

}
