package ch.mrs.matrix.math;

public class MathFactory {
	private final static MathFactory INSTANCE = new MathFactory();
	
	private MathFactory() {
		// factory
	}
	
	public static MathFactory getInstance() {
		return INSTANCE;
	}
//	public List<BinaryRange<Integer>> toBinaryDistribution(List<Range<Integer>> distribution, List<Double> weights) {
//		return BinaryDistributionConverter.getInstance().toBinaryDistribution(distribution, weights);
//	}

	public <T> DistributionGenerator<T> createDistributionGenerator() {
		return new DistributionGeneratorImpl<T>();
	}
	
	public <T> Distribution<T> createDistribution(T category, double percent) {
		return new DistributionImpl<T>(category, percent);
	}

	public <T extends Number> Range<T> createRange(T minimum, T maximum) {
		return new RangeImpl<T>(minimum, maximum);
	}
	
	public Random createRandom() {
		return new RandomImpl();
	}
}
