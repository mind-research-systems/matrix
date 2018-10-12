package ch.mrs.matrix.math;

import java.util.List;

public class MathFactory {

	private MathFactory() {
		// factory
	}
	
	public static List<BinaryRange<Integer>> toBinaryDistribution(List<Range<Integer>> distribution, List<Double> weights) {
		return DistributionConverter.getInstance().toBinaryDistribution(distribution, weights);
	}

	public static <T extends Number> Range<T> createRange(T minimum, T maximum) {
		return new RangeImpl<T>(minimum, maximum);
	}
	
	public static Random createRandom() {
		return new RandomImpl();
	}
}
