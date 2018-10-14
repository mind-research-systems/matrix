package ch.mrs.matrix.math;

import ch.mrs.matrix.validation.Validate;

class DistributionImpl<T> implements Distribution<T> {
	private final static double PERCENT_DIVISOR = 100.0;
	private final static double ONE = 1.0;
	private final T category;
	private final double percent;

	DistributionImpl(T category, Double percent) {
		super();
		this.category = category;
		this.percent = divideByPercentDivisorIfGreaterThatnOne(percent);
		Validate.notNull(category);
	}

	private double divideByPercentDivisorIfGreaterThatnOne(Double value) {
		Validate.notNull(value);
		return value > ONE ? value / PERCENT_DIVISOR : value;
	}
	@Override
	public T getCategory() {
		return category;
	}

	@Override
	public double getPercent() {
		return percent;
	}
}
