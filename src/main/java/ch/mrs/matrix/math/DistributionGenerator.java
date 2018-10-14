package ch.mrs.matrix.math;

import java.util.Collection;

public interface DistributionGenerator<T> {
	void add(Distribution<T> distribution);
	void reset(Collection<Distribution<T>> distributions);
	void validateSumOfDistributionsEqualsOne();
	T nextValue();
	Collection<Distribution<T>> getDistributions();
}
