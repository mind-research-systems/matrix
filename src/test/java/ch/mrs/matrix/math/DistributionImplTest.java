package ch.mrs.matrix.math;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class DistributionImplTest {
	private static final double DELTA = 0.0;
	private static final double PERCENT_BASE_100 = 49.8;
	private static final double PERCENT_BASE_ONE = 0.498;
	private Distribution<Sex> testee;
	
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
	@Before
	public void setup() {
		testee = new DistributionImpl<>(Sex.MALE, PERCENT_BASE_ONE);
	}
	
	@Test
	public void getPercentBase100_EqualsPercentBaseOne() {
		// arrange
		testee = new DistributionImpl<>(Sex.MALE, PERCENT_BASE_100);
		//act
		double result = testee.getPercent();
		// assert
		assertEquals(PERCENT_BASE_ONE,result, DELTA);
	}
	
	@Test
	public void getPercentBaseOne_EqualsPercentBaseOne() {
		// arrange, act
		double result = testee.getPercent();
		// assert
		assertEquals(PERCENT_BASE_ONE,result, DELTA);
	}
	
	@Test
	public void getCategory_EqualsCategory() {
		// arrange, act
		Sex result = testee.getCategory();
		// assert
		assertEquals(Sex.MALE,result);
	}
	
	@Test
	public void ctor_CategoryNull_Exception() {
		// arrange, preassert
		exceptionRule.expect(IllegalArgumentException.class);
		// act
		new DistributionImpl<>(null,PERCENT_BASE_ONE);
	}
	
	@Test
	public void ctor_PercentNull_Exception() {
		// arrange, preassert
		exceptionRule.expect(IllegalArgumentException.class);
		// act
		new DistributionImpl<>(Sex.FEMALE,null);
	}
}
