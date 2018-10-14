package ch.mrs.matrix.math;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ch.mrs.matrix.math.Random;
import ch.mrs.matrix.math.RandomImpl;

public class RandomImplTest {
	private static final int ZERO = 0;
	private static final int ONE = 1;
	private static final int SEVEN = 7;
	private static final int FIVE = 5;
	private static final double NINE = 9.0;
	private static final double TWENTYFIVE = 25.0;
	private Random testee;
	
	@Before
	public void setup() {
		testee = new RandomImpl();
	}
	
	@Test
	public void random_doubleValue() {
		// arrange, act
		double result = testee.random();
		// assert
		assertNotNull(result);
		assertTrue("Must be greeater tahn or equal to zero", result >= ZERO);
		assertTrue("Must be greeater less than one", result < ONE);
	}
	
	@Test
	public void random_BetweenFiveAndSeven_InRange() {
		// arrange, act
		int result = testee.random(FIVE,SEVEN);
		// assert
		assertNotNull(result);
		assertTrue("Must be greeater tahn or equal to five", result >= FIVE);
		assertTrue("Must be greeater less than or equal to seven", result <= SEVEN);
	}
	
	@Test
	public void random_BetweenBineTwenityFive_InRange() {
		// arrange, act
		double result = testee.random(NINE,TWENTYFIVE);
		// assert
		assertNotNull(result);
		assertTrue("Must be greeater tahn or equal to five", result >= NINE);
		assertTrue("Must be greeater less than or equal to seven", result <= TWENTYFIVE);
	}
	
}
