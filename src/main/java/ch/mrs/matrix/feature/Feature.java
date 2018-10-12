package ch.mrs.matrix.feature;

/**
 * A feature is an attribute of the matrix or of one of its entities.
 * Unlike a variable not the value is stored for a symbol, but a
 * description of the value type. Values can only be numbers in a range 
 * or the name of an enumeration type. 
 * @author donatmueller
 *
 */
public interface Feature {
	String getName();
}
