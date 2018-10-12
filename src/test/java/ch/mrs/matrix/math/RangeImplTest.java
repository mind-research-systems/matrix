package ch.mrs.matrix.math;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class RangeImplTest {
	private static final int TWELVE = 12;
	private static final int TWENTYTREE = 23;
	private static final int BETWEEN = 17;
	private static final int BELOW = 6;
	private static final int ABOVE = 25;
	private Range<Integer> testee;
	
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
	@Before
	public void setup() {
		testee = new RangeImpl<>(TWELVE,TWENTYTREE);
	}
	
	@Test
	public void getMinimum_EqualsMinimum() {
		// arrange, act
		int result = testee.getMinimum();
		// assert
		assertEquals(TWELVE,result);
	}
	
	@Test
	public void getMaximum_EqualsMaximum() {
		// arrange, act
		int result = testee.getMaximum();
		// assert
		assertEquals(TWENTYTREE,result);
	}
	
	@Test
	public void inside_Below_False() {
		// arrange, act
		boolean result = testee.inside(BELOW);
		// assert
		assertFalse(result);
	}
	
	@Test
	public void inside_Above_False() {
		// arrange, act
		boolean result = testee.inside(ABOVE);
		// assert
		assertFalse(result);
	}
	
	@Test
	public void inside_Inside_True() {
		// arrange, act
		boolean result = testee.inside(BETWEEN);
		// assert
		assertTrue(result);
	}
	
	@Test
	public void toString_NotNull() {
		// arrange, act
		String result = testee.toString();
		// assert
		assertNotNull(result);
	}
	
	@Test
	public void ctor_MinimumNull_Exception() {
		// arrange, preassert
		exceptionRule.expect(IllegalArgumentException.class);
		// act
		new RangeImpl<>(null,TWENTYTREE);
	}
	
	@Test
	public void ctor_MaximumNull_Exception() {
		// arrange, preassert
		exceptionRule.expect(IllegalArgumentException.class);
		// act
		new RangeImpl<>(TWELVE,null);
	}
}
