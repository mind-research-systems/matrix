package ch.mrs.matrix.math;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MathFactoryTest {
	private static final int MINIMUM = 28;
	private static final int MAXIMUM = 45;
	private static final List<Range<Integer>> DISTRIBUTION = new ArrayList<>();
	private static final List<Double> WEIGTHS = new ArrayList<>();
	
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
	public void toBinaryDistribution_Any_NotNull() {
		// arrange, act
		List<BinaryRange<Integer>> result = testee.toBinaryDistribution(DISTRIBUTION, WEIGTHS);
		// assert
		assertNotNull(result);
	}
	
	@Test
	public void createRange_Any_NotNull() {
		// arrange, act
		Range<Integer> result = testee.createRange(MINIMUM, MAXIMUM);
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
	
	@Test
	public void toBinaryDistribution_DistributionNull_Exception() {
		// arrange, preassert
		exceptionRule.expect(IllegalArgumentException.class);
		// act
		testee.toBinaryDistribution(null, WEIGTHS);
	}
	
	@Test
	public void toBinaryDistribution_WeightsNull_Exception() {
		// arrange, preassert
		exceptionRule.expect(IllegalArgumentException.class);
		// act
		testee.toBinaryDistribution(DISTRIBUTION, null);
	}

}
