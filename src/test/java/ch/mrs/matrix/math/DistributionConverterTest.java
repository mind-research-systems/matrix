package ch.mrs.matrix.math;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class DistributionConverterTest {
	@Test
	public void toBinaryDistribution_FourRangesWeightsBetweenZeroAndOne_CorrectTresholds() {
		// arrange
		List<Range<Integer>> distribution = createSampleDistribution();
		List<Double> weights = createSampleWeights();
		// act
		List<BinaryRange<Integer>> result = DistributionConverter.getInstance().toBinaryDistribution(distribution, weights);
		// assert
		assertBinaryDistribution(result);
	}
	
	@Test
	public void toBinaryDistribution_FourRangesWeightsInPercent_CorrectTresholds() {
		// arrange
		List<Range<Integer>> distribution = createSampleDistribution();
		List<Double> weights = createSampleWeightsPercent();
		// act
		List<BinaryRange<Integer>> result = DistributionConverter.getInstance().toBinaryDistribution(distribution, weights);
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
		distribution.add(MathFactory.createRange(0,1));
		distribution.add(MathFactory.createRange(0,2));
		distribution.add(MathFactory.createRange(0,2));
		distribution.add(MathFactory.createRange(0,4));
		distribution.add(MathFactory.createRange(0,11));
		return distribution;
	}
	
	private List<Double> createSampleWeights() {
		List<Double> weights = new ArrayList<>();
		weights.add(0.05);
		weights.add(0.10);
		weights.add(0.10);
		weights.add(0.20);
		weights.add(0.55);
		return weights;
	}
	private List<Double> createSampleWeightsPercent() {
		List<Double> weights = new ArrayList<>();
		weights.add(5.0);
		weights.add(10.0);
		weights.add(10.0);
		weights.add(20.0);
		weights.add(55.0);
		return weights;
	}
}
