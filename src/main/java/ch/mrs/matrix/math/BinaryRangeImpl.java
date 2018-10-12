package ch.mrs.matrix.math;

import ch.mrs.matrix.validation.Validate;

class BinaryRangeImpl implements BinaryRange<Integer> {
	private final double triggerValueInPercent;
	private final Range<Integer> rangeBelow;
	private final Range<Integer> rangeAbove;
	
	BinaryRangeImpl(double triggerValueInPercent, Range<Integer> rangeBelow, Range<Integer> rangeAbove) {
		super();
		this.triggerValueInPercent = triggerValueInPercent;
		this.rangeBelow = rangeBelow;
		this.rangeAbove = rangeAbove;
		Validate.notNull(rangeBelow);
		Validate.notNull(rangeAbove);
	}

	@Override
	public Range<Integer> select(double randomPercent) {
		return randomPercent <= triggerValueInPercent ? rangeBelow : rangeAbove;
	}

	@Override
	public double getTriggerValue() {
		return triggerValueInPercent;
	}
}