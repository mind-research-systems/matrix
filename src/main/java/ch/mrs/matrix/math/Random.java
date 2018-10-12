package ch.mrs.matrix.math;

/**
 * @author donatmueller
 *
 */
public interface Random {
	
	/**
	 * @return a double value between 0.0 and 1.0
	 */
	double random();
	
	/**
	 * @param min
	 * @param max
	 * @return a int between min and max 
	 */
	int random(int min, int max);
	/**
	 * @param min
	 * @param max
	 * @return a double between min and max 
	 */
	double random(double min, double max);
}
