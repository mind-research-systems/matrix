package ch.mrs.matrix.math;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import ch.mrs.matrix.validation.Validate;

class DistributionGeneratorImpl<T> implements DistributionGenerator<T> {
	private final static double ZERO = 0.0;
	private final static double ONE = 1.0;
	private final List<Distribution<T>> distributions = new ArrayList<>();
	
	@Override
	public void add(Distribution<T> distribution) {
		Validate.notNull(distribution);
		distributions.add(distribution);
	}

	@Override
	public void reset(Collection<Distribution<T>> distributions) {
		Validate.notNull(distributions);
		this.distributions.clear();
		this.distributions.addAll(distributions);
		
	}

	@Override
	public T nextValue() {
		int index = 0;
		double summedDistribution = ZERO;
		double random = MathFactory.getInstance().createRandom().random();
		while (summedDistribution < random) {
			summedDistribution += distributions.get(index++).getPercent();
		}

		return distributions.get(index - 1).getCategory();
	}

	@Override
	public void validateSumOfDistributionsEqualsOne() {
		double sumOfDistributions = distributions.stream().mapToDouble(Distribution::getPercent).sum();
		Validate.isTrue(sumOfDistributions == ONE);
	}

	@Override
	public Collection<Distribution<T>> getDistributions() {
		return Collections.unmodifiableList(distributions);
	}
}
