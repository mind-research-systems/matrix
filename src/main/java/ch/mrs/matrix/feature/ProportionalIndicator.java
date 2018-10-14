package ch.mrs.matrix.feature;

import java.util.List;

public interface ProportionalIndicator extends Indicator {
	List<IndicatorProportion> getProportions();
	void loadValue(Double... value);
}
