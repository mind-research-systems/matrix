package ch.mrs.matrix.feature;

import ch.mrs.matrix.math.Range;

public interface IndicatorProportion extends Indicator {
	// TODO alter to: int generateValue(); 
	// TODO then implementors can return an integer in a range or as the ordinal value of an enum type such as Sex
	Range<Integer> getRange();
}
