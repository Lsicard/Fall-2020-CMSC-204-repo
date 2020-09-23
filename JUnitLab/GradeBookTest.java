import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTest {
	private GradeBook g1;
	private GradeBook g2;
	@BeforeEach
	void setUp() throws Exception {
		g1 = new GradeBook(5);
		g1.addScore(0);
		g1.addScore(25);
		g1.addScore(50);
		g1.addScore(75);
		g1.addScore(100);
		
		g2 = new GradeBook(5);
		g2.addScore(33.33);
		g2.addScore(66.66);
		g2.addScore(99.99);
	}

	@AfterEach
	void tearDown() throws Exception {
		g1 = null;
		g2 = null;
	}

	@Test
	void testAddScore() {
		assertTrue(g1.toString().equals("0.0 25.0 50.0 75.0 100.0"));
		assertEquals(g1.getScoreSize(), 5);
		assertTrue(g2.toString().equals("33.33 66.66 99.99"));
		assertEquals(g2.getScoreSize(), 3);
	}

	@Test
	void testSum() {
		assertEquals(g1.sum(), 250.0);
		assertEquals(g2.sum(), 199.98);
	}

	@Test
	void testMinimum() {
		assertEquals(g1.minimum(), 0.0);
		assertEquals(g2.minimum(), 33.33);
	}
	
	@Test
	void testFinalScore() {
		assertEquals(g1.finalScore(), 250.0);
		assertEquals(g2.finalScore(), 166.65, .001);
	}
}
