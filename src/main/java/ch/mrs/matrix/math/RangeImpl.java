package ch.mrs.matrix.math;

import ch.mrs.matrix.validation.Validate;

class RangeImpl<T extends Number> implements Range<T> {
	private final T minimum;
	private final T maximum;

	public RangeImpl(T minimum, T maximum) {
		this.minimum = minimum;
		this.maximum = maximum;
		Validate.notNull(minimum);
		Validate.notNull(maximum);
	}


	@Override
	public T getMinimum() {
		return minimum;
	}

	@Override
	public T getMaximum() {
		return maximum;
	}


	@Override
	public boolean inside(T value) {
		Validate.notNull(value);
		double d = value.doubleValue();
		return getMinimum().doubleValue() <= d && d <= getMaximum().doubleValue();
	}


	@Override
	public String toString() {
		return "Range [min=" + minimum + ", max=" + maximum + "]";
	}
}
