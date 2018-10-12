package ch.mrs.matrix.math;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * Decomposing Non-Uniform Distributions
 * Example 1
 * @see https://oroboro.com/non-uniform-random-numbers/
 * @author donatmueller
 *
 */
public class DistributionConverterTest {
	
	private MathFactory mathFactory;
	private DistributionConverter testee;
	
	@Before
	public void setup() {
		testee = DistributionConverter.getInstance();
		mathFactory = MathFactory.getInstance();
	}
	
	@Test
	public void getInstance_NotNull() {
		assertNotNull(testee);
		assertNotNull(mathFactory);
	}
	
	@Test
	public void toBinaryDistribution_FourRangesWeightsBetweenZeroAndOne_CorrectTresholds() {
		// arrange
		List<Range<Integer>> distribution = createSampleDistribution();
		List<Double> weights = createSampleWeightsBetweenZeroAndOne();
		// act
		List<BinaryRange<Integer>> result = testee.toBinaryDistribution(distribution, weights);
		// assert
		assertBinaryDistribution(result);
	}
	
	@Test
	public void toBinaryDistribution_FourRangesWeightsInPercent_CorrectTresholds() {
		// arrange
		List<Range<Integer>> distribution = createSampleDistribution();
		List<Double> weights = createSampleWeightsInPercent();
		// act
		List<BinaryRange<Integer>> result = testee.toBinaryDistribution(distribution, weights);
		// assert
		assertBinaryDistribution(result);
	}
	
	private void assertBinaryDistribution(List<BinaryRange<Integer>> result) {
		assertEquals(4, result.size());
		assertEquals(20,result.get(0).getTriggerValue(),0.0);
		assertEquals(40,result.get(1).getTriggerValue(),0.0);
		assertEquals(40,result.get(2).getTriggerValue(),0.0);
		assertEquals(80,result.get(3).getTriggerValue(),0.0);
	}

	private List<Range<Integer>> createSampleDistribution() {
		List<Range<Integer>> distribution = new ArrayList<>();
		distribution.add(mathFactory.createRange(0,1));
		distribution.add(mathFactory.createRange(0,2));
		distribution.add(mathFactory.createRange(0,2));
		distribution.add(mathFactory.createRange(0,4));
		distribution.add(mathFactory.createRange(0,11));
		return distribution;
	}
	
	/**
	 * A: 0.05
	 * B: 0.10
	 * C: 0.10
	 * D: 0.20
	 * E: 0.55
	 * @return
	 */
	private List<Double> createSampleWeightsBetweenZeroAndOne() {
		List<Double> weights = new ArrayList<>();
		weights.add(0.05);
		weights.add(0.10);
		weights.add(0.10);
		weights.add(0.20);
		weights.add(0.55);
		return weights;
	}
	
	/**
	 * A:  5.0
	 * B: 10.0
	 * C: 10.0
	 * D: 20.0
	 * E: 55.0
	 * @return
	 */
	private List<Double> createSampleWeightsInPercent() {
		List<Double> weights = new ArrayList<>();
		weights.add(5.0);
		weights.add(10.0);
		weights.add(10.0);
		weights.add(20.0);
		weights.add(55.0);
		return weights;
	}
}
