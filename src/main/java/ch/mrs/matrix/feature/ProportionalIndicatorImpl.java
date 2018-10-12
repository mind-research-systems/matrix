package ch.mrs.matrix.feature;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ch.mrs.matrix.math.BinaryRange;
import ch.mrs.matrix.math.MathFactory;
import ch.mrs.matrix.math.Random;
import ch.mrs.matrix.math.Range;
import ch.mrs.matrix.validation.Validate;

public class ProportionalIndicatorImpl extends IndicatorImpl implements ProportionalIndicator {
	private final List<IndicatorProportion> proportions;
	private List<Double> values = new ArrayList<>();
	List<BinaryRange<Integer>> binaryRanges = null;
	
	public ProportionalIndicatorImpl(String name, List<IndicatorProportion> proportions) {
		super(name, PROPORTIONAL_INDICATOR_ID);
		this.proportions = proportions;
		Validate.notNull(proportions);
	}
	@Override
	public List<IndicatorProportion> getProportions() {
		return proportions;
	}
	
	@Override
	public void loadValue(double... values) {
		Validate.isTrue(values.length==proportions.size());
		this.values.clear();
		for (double value : values) {
			this.values.add(value);
		}
		List<Range<Integer>> distribution = proportions.stream().map(IndicatorProportion::getRange).collect(Collectors.toList());
		this.binaryRanges = MathFactory.getInstance().toBinaryDistribution(distribution, this.values);
	}
	
	@Override
	public int getValue() {
		Validate.isTrue(!values.isEmpty());
		final Random random = MathFactory.getInstance().createRandom();
		BinaryRange<Integer> binaryRange = binaryRanges.get(random.random(0, getProportions().size() - 2));
		Range<Integer> range = binaryRange.select(random.random(0.0,100.0));
		return random.random(range.getMinimum(), range.getMaximum());
	}
}
