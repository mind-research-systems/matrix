package ch.mrs.matrix.math;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import ch.mrs.matrix.feature.test.AbstractFactoryTest;

public class MathFactoryTest extends AbstractFactoryTest {
	private static final int MINIMUM = 28;
	private static final int MAXIMUM = 45;
	private static final List<Range<Integer>> DISTRIBUTION = new ArrayList<>();
	private static final List<Double> WEIGTHS = new ArrayList<>();
	
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
	@Override
	protected Class<?> getFactoryClass() {
		return MathFactory.class;
	}
	
	@Test
	public void toBinaryDistribution_Any_NotNull() {
		// arrange, act
		List<BinaryRange<Integer>> result = MathFactory.toBinaryDistribution(DISTRIBUTION, WEIGTHS);
		// assert
		assertNotNull(result);
	}
	
	@Test
	public void createRange_Any_NotNull() {
		// arrange, act
		Range<Integer> result = MathFactory.createRange(MINIMUM, MAXIMUM);
		// assert
		assertNotNull(result);
	}
	
	@Test
	public void getRandom_NotNull() {
		// arrange, act
		Random result = MathFactory.createRandom();
		// assert
		assertNotNull(result);
	}
	
	@Test
	public void toBinaryDistribution_DistributionNull_Exception() {
		// arrange, preassert
		exceptionRule.expect(IllegalArgumentException.class);
		// act
		MathFactory.toBinaryDistribution(null, WEIGTHS);
	}
	
	@Test
	public void toBinaryDistribution_WeightsNull_Exception() {
		// arrange, preassert
		exceptionRule.expect(IllegalArgumentException.class);
		// act
		MathFactory.toBinaryDistribution(DISTRIBUTION, null);
	}

}
