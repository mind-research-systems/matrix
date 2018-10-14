package ch.mrs.matrix.math;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MathFactoryTest {
	private static final int MINIMUM = 28;
	private static final int MAXIMUM = 45;
	private static final double PERCENT = 50.2;
	private static final String CATEGORY = "female";
	
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
	private MathFactory testee;
	
	@Before 
	public void setup() {
		testee = MathFactory.getInstance();
	}
	
	@Test
	public void getInstance_NotNull() {
		assertNotNull(testee);
	}
	
	@Test
	public void createRange_Any_NotNull() {
		// arrange, act
		Range<Integer> result = testee.createRange(MINIMUM, MAXIMUM);
		// assert
		assertNotNull(result);
	}
	
	@Test
	public void createDistribution_Any_NotNull() {
		// arrange, act
		Distribution<String> result = testee.createDistribution(CATEGORY, PERCENT);
		// assert
		assertNotNull(result);
	}
	
	@Test
	public void getRandom_NotNull() {
		// arrange, act
		Random result = testee.createRandom();
		// assert
		assertNotNull(result);
	}
	
}
