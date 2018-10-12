package ch.mrs.matrix.math;

import static org.junit.Assert.*;

import org.junit.Test;

public class BinaryRangeImplTest {
	private static final double EXACT = 0.0;
	private static final double TRIGGER_VALUE = 14.3;
	private static final double BELOW = 9;
	private static final double ABOVE = 15;
	private static final Range<Integer> LOWER = MathFactory.getInstance().createRange(10, 50);
	private static final Range<Integer> UPPER = MathFactory.getInstance().createRange(60, 90);

	@Test
	public void getTriggerValue_ValueAsSet() {
		// arrange
		BinaryRange<?> testee = createTestee();
		// act
		double result = testee.getTriggerValue();
		// assert
		assertEquals(TRIGGER_VALUE,result,EXACT);
	}

	@Test
	public void select_below_getLower() {
		// arrange
		BinaryRange<?> testee = createTestee();
		// act
		Range<?> result = testee.select(BELOW);
		// assert
		assertEquals(LOWER,result);
	}

	@Test
	public void select_above_getUpper() {
		// arrange
		BinaryRange<?> testee = createTestee();
		// act
		Range<?> result = testee.select(ABOVE);
		// assert
		assertEquals(UPPER,result);
	}

	private BinaryRangeImpl createTestee() {
		return new BinaryRangeImpl(TRIGGER_VALUE, LOWER, UPPER);
	}
}
