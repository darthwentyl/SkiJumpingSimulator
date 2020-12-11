import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SkiJumpingJudgeTest {

    @Test
    void test() {
        SkiJumpingJudge judge = new SkiJumpingJudge();
        assertTrue(judge.getStylePoints() <= 20);
        assertTrue(judge.getStylePoints() >= 10);
    }

}
