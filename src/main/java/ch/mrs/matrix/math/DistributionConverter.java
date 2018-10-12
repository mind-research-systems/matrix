package ch.mrs.matrix.math;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ch.mrs.matrix.validation.Validate;

/**
 * Generation of Non-Uniform Random Numbers
 * @see https://oroboro.com/non-uniform-random-numbers/
 * @author donatmueller
 */
class DistributionConverter {
	
	static final DistributionConverter INSTANCE = new DistributionConverter();
	
	private DistributionConverter() {
		// factory
	}

	public static DistributionConverter getInstance() {
		return DistributionConverter.INSTANCE;
	}
	
	List<BinaryRange<Integer>> toBinaryDistribution(List<Range<Integer>> distribution, List<Double> weight) {
		Validate.notNull(distribution);
		Validate.notNull(weight);
		List<BinaryRange<Integer>> result = new ArrayList<>();
		double sumWeights = weight.stream().collect(Collectors.summingDouble(x -> x));
		int lastIndex = distribution.size() - 1;
		for (int i = 0; i < lastIndex; i++) {
			double triggerValueInPercent =  weight.get(i) / sumWeights * 100 * lastIndex;
			result.add(new BinaryRangeImpl(triggerValueInPercent, distribution.get(i), distribution.get(lastIndex)));
		}
		return result;
	}
}
