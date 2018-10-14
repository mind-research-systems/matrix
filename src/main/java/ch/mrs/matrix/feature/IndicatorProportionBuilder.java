package ch.mrs.matrix.feature;

import java.util.List;

public interface IndicatorProportionBuilder {
	IndicatorProportionBuilder addIndicatorProportion(String name, String indicatorId, int min, int max);
	List<IndicatorProportion> build();
}
