package ch.mrs.matrix.feature;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ch.mrs.matrix.math.DistributionGenerator;
import ch.mrs.matrix.math.MathFactory;
import ch.mrs.matrix.math.Random;
import ch.mrs.matrix.validation.Validate;

/**
 * Generation of Non-Uniform Random Numbers
 * Implements from: Example 1 (Step 3)
 * @see https://oroboro.com/non-uniform-random-numbers/
 * 
 * @author donatmueller
 */
public class ProportionalIndicatorImpl extends IndicatorImpl implements ProportionalIndicator {
	private final MathFactory mathFactory;
	private final Random random ;
	private final List<IndicatorProportion> proportions;
	private final List<Double> values;
	private final DistributionGenerator<IndicatorProportion> distributionGenerator;
	
	public ProportionalIndicatorImpl(String name, List<IndicatorProportion> proportions) {
		super(name, PROPORTIONAL_INDICATOR_ID);
		this.mathFactory = MathFactory.getInstance();
		this.random = mathFactory.createRandom();
		this.proportions = proportions;
		this.values = new ArrayList<>();
		this.distributionGenerator = MathFactory.getInstance().createDistributionGenerator();
		Validate.notNull(proportions);
	}
	@Override
	public List<IndicatorProportion> getProportions() {
		return proportions;
	}
	
	@Override
	public void loadValue(Double... values) {
		Validate.isTrue(values.length==proportions.size());
		this.values.clear();
		for (double value : values) {
			this.values.add(value);
		}
		distributionGenerator.reset(Collections.emptyList());
		for (int i=0; i<values.length; i++) {
			distributionGenerator.add(mathFactory.createDistribution(this.proportions.get(i), this.values.get(i)));
		}
	}
	
	@Override
	public int getValue() {
		Validate.isTrue(!values.isEmpty());
		IndicatorProportion value = distributionGenerator.nextValue();
		return random.random(value.getRange().getMinimum(), value.getRange().getMaximum());
	}
}
