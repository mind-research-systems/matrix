package ch.mrs.matrix.feature;

import java.util.List;

import ch.mrs.matrix.math.Range;

public class FeatureFactory {
	private final static FeatureFactory INSTANCE = new FeatureFactory();
	private FeatureFactory() {
		// factory
	}

	public static FeatureFactory getInstance() {
		return FeatureFactory.INSTANCE;
	}
	
	public Indicator createIndicator(String name, String indicatorId) {
		return new IndicatorImpl(name, indicatorId);
	}
	
	public ProportionalIndicator createProportionalIndicator(String name, List<IndicatorProportion> proportions) {
		return new ProportionalIndicatorImpl(name, proportions);
	}
	
	public IndicatorProportionImpl createIndicatorProportion(String name, String indicatorId, Range<Integer> range) {
		return new IndicatorProportionImpl(name, indicatorId, range);
	}
}
