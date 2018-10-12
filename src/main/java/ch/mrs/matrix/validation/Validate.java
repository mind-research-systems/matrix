package ch.mrs.matrix.validation;

import java.util.Collection;

public class Validate {
	public static void one(int value) {
		if (value != 1) {
			throw new IllegalArgumentException("Only 1 expected.");
		}
	}
	public static void positive(int value) {
		if (value < 0) {
			throw new IllegalArgumentException("Only positive values allowed.");
		}
	}
	public static void isLessThanOrEqual(int a, int b) {
		if (a > b) {
			throw new IllegalArgumentException(String.format("Number greater than %s not allowed." ,a));
		}
	}
	public static void notNull(Object object) {
		if (object == null) {
			throw new IllegalArgumentException("Null not allowed.");
		}
	}
	public static void isTrue(boolean value) {
		if (!value) {
			throw new IllegalArgumentException("Not true.");
		}
	}
	public static void contains(Collection<?> collection, Object object) {
		if (!collection.contains(object)) {
			throw new IllegalArgumentException(String.format("Object %s is not in %s", object, collection));
		}
	}
}
