package ch.mrs.matrix.validation;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ValidateTest {
	private static final int NEGATIVE = -1;
	private static final int ONE = 1;
	private static final int ZERO = 0;
	private static final Collection<String> ITEMS = Arrays.asList(new String[] {"a","b"});
	
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
	@Test
	public void one_One_NoException() {
		// arrange, preassert, act
		Validate.one(ONE);
	}

	@Test
	public void one_Zero_Exception() {
		// arrange, preassert
		exceptionRule.expect(IllegalArgumentException.class);
		// act
		Validate.one(ZERO);
	}
	
	@Test
	public void positive_Zero_NoException() {
		// arrange, preassert, act
		Validate.positive(ONE);
	}

	@Test
	public void positive_Negative_Exception() {
		// arrange, preassert
		exceptionRule.expect(IllegalArgumentException.class);
		// act
		Validate.positive(NEGATIVE);
	}
	
	@Test
	public void isLessThanOrEqual_ZeroZero_NoException() {
		// arrange, preassert, act
		Validate.isLessThanOrEqual(ZERO,ZERO);
	}

	@Test
	public void isLessThanOrEqual_OneZero_Exception() {
		// arrange, preassert
		exceptionRule.expect(IllegalArgumentException.class);
		// act
		Validate.isLessThanOrEqual(ONE,ZERO);
	}
	
	@Test
	public void notNull_NotNull_NoException() {
		// arrange, preassert, act
		Validate.notNull("something");
	}

	@Test
	public void notNull_Null_Exception() {
		// arrange, preassert
		exceptionRule.expect(IllegalArgumentException.class);
		// act
		Validate.notNull(null);
	}
	@Test
	public void contains_In_NoException() {
		// arrange, preassert, act
		Validate.contains(ITEMS,"a");
	}

	@Test
	public void contains_NotIn_Exception() {
		// arrange, preassert
		exceptionRule.expect(IllegalArgumentException.class);
		// act
		Validate.contains(ITEMS,"c");
	}

}
