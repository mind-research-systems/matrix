package ch.mrs.matrix.feature;

import java.util.ArrayList;
import java.util.List;

import ch.mrs.matrix.math.MathFactory;

class IndicatorProportionBuilderImpl implements IndicatorProportionBuilder {
	List<IndicatorProportion> proportions = new ArrayList<>();
	
	@Override
	public IndicatorProportionBuilder addIndicatorProportion(String name, String indicatorId, int min, int max) {
		proportions.add(FeatureFactory.getInstance().createIndicatorProportion(name, indicatorId, MathFactory.getInstance().createRange(min, max)));
		return this;
	}

	@Override
	public List<IndicatorProportion>  build() {
		return proportions;
	}
}
