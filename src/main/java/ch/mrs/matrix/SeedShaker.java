package ch.mrs.matrix;

/**
 * The seedshaker instantiates the matrix based on seeds.
 * There are two kind of indicator values that can be mapped to features.
 * Single values without a distribution representing the number of instances of something.
 * For example the count of the population in a region for a year.
 * On the other side there are distributed values representing an attribute of many instances.
 * For example sex has two values 'm' and 'f' with a distribution of 49.2 and 50.8 percent.
 * The seedshaker will create the number of individuals according to the population feature
 * and set the sex among all individuals so that the distribution of 49.2 and 50.8 percent is met.
 * 
 * @see https://oroboro.com/non-uniform-random-numbers/ for a sophisticated distribution algorithm.
 *  
 * @author donatmueller
 *
 */
public class SeedShaker {

	public SeedShaker() {
		// TODO Auto-generated constructor stub
	}

}
