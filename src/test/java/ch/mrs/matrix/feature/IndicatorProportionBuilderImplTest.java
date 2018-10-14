package ch.mrs.matrix.feature;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class IndicatorProportionBuilderImplTest {
	private static final String NAME = "size";
	private static final String ID = "42";
	private static final int MIN = 16;
	private static final int MAX = 31;
	private IndicatorProportionBuilder testee;
	
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();

	@Before
	public void setup() {
		testee = new IndicatorProportionBuilderImpl();
	}

	@Test
	public void addIndicatorProportion_EqualsRange() {
		// arrange, act
		IndicatorProportionBuilder result = testee.addIndicatorProportion(NAME,ID,MIN,MAX);
		// assert
		assertEquals(testee,result);
	}

	@Test
	public void build_EMptyProportions() {
		// arrange, act
		List<IndicatorProportion> result = testee.build();
		// assert
		assertTrue(result.isEmpty());
	}

}
