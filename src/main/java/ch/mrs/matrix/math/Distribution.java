package ch.mrs.matrix.math;

/**
 * A distribution in % for a category T.
 * @author donatmueller
 *
 */
public interface Distribution<T> {
	/**
	 * 
	 * @return category of type T
	 */
	T getCategory();
	/**
	 * @return % in the range between 0 and 1
	 */
	double getPercent();
}
