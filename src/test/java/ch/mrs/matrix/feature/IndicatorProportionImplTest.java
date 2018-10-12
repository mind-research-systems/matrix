package ch.mrs.matrix.feature;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import ch.mrs.matrix.math.MathFactory;
import ch.mrs.matrix.math.Range;

public class IndicatorProportionImplTest {
	private static final String NAME = "size";
	private static final String ID = "42";
	private static final Range<Integer> RANGE = MathFactory.getInstance().createRange(15, 25);
	private IndicatorProportion testee;
	
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();

	@Before
	public void setup() {
		testee = new IndicatorProportionImpl(NAME,ID,RANGE);
	}

	@Test
	public void getRange_EqualsRange() {
		// arrange, act
		Range<Integer> result = testee.getRange();
		// assert
		assertEquals(RANGE,result);
	}
}
