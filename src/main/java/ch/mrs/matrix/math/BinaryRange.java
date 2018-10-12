package ch.mrs.matrix.math;

public interface BinaryRange<T extends Number> {
	Range<T> select(double randomPercent);
	double getTriggerValue();
}
