package Labs.Junit_Lab;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GradebookTester {

    private GradeBook test, test2;

    @Before
    public void setUp() {
        test = new GradeBook(5);
        test2 = new GradeBook(5);

        test.addScore(20);
        test.addScore(90);
        test.addScore(95);

        test2.addScore(90);
        test2.addScore(95);
        test2.addScore(100);
    }

    @After
    public void tearDown() {
        test = null;
    }

    @Test
    public void testAddScore() {
        assertTrue(test.toString().equals("20.0 90.0 95.0 "));
        assertTrue(test2.toString().equals("90.0 95.0 100.0 "));
        assertEquals(3, test.getScoreSize(), 0.001);
        assertEquals(3, test2.getScoreSize(), 0.001);
    }

    @Test
    public void testSum() {
        assertEquals(205, test.sum(), 0.0001);
        assertEquals(285, test2.sum(), 0.0001);
    }

    @Test
    public void testMinimum() {
        assertEquals(20, test.minimum(), 0.001);
        assertEquals(90, test2.minimum(), 0.001);
    }

    @Test
    public void testFinalScore() {
        assertEquals(185, test.finalScore(), 0.0001);
        assertEquals(195, test2.finalScore(), 0.0001);
    }

}
