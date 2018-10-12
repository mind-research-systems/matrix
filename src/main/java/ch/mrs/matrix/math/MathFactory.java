package ch.mrs.matrix.math;

import java.util.List;

public class MathFactory {
	private final static MathFactory INSTANCE = new MathFactory();
	
	private MathFactory() {
		// factory
	}
	
	public static MathFactory getInstance() {
		return INSTANCE;
	}
	public List<BinaryRange<Integer>> toBinaryDistribution(List<Range<Integer>> distribution, List<Double> weights) {
		return DistributionConverter.getInstance().toBinaryDistribution(distribution, weights);
	}

	public <T extends Number> Range<T> createRange(T minimum, T maximum) {
		return new RangeImpl<T>(minimum, maximum);
	}
	
	public Random createRandom() {
		return new RandomImpl();
	}
}
