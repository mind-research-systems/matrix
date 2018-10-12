package ch.mrs.matrix.feature;

import ch.mrs.matrix.math.Range;
import ch.mrs.matrix.validation.Validate;

public class IndicatorProportionImpl extends IndicatorImpl implements IndicatorProportion {
	private final Range<Integer>  range;
	public IndicatorProportionImpl(String name, String indicatorId, Range<Integer>  range) {
		super(name, indicatorId);
		this.range = range;
		Validate.notNull(range);
	}

	@Override
	public Range<Integer> getRange() {
		return range;
	}
}
