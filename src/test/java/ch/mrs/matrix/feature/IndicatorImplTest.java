package ch.mrs.matrix.feature;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class IndicatorImplTest {
	private static final String NAME = "sex";
	private static final String ID = "42";
	private static final Integer VALUE = 1;
	private Indicator testee;
	
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();

	@Before
	public void setup() {
		testee = new IndicatorImpl(NAME,ID);
	}

	@Test
	public void getIndicatorId_EqualsId() {
		// arrange, act
		String result = testee.getIndicatorId();
		// assert
		assertEquals(ID,result);
	}
	
	@Test
	public void getValue_Exception() {
		// arrange, preassert
		exceptionRule.expect(IllegalArgumentException.class);
		// act
		testee.getValue();
	}
	
	@Test
	public void getValue_AfterLOadValue_EqualsValue() {
		// arrange
		testee.loadValue(VALUE);
		// act
		Integer result = testee.getValue();
		// assert
		assertNotNull(result);
		assertEquals(VALUE,result);
	}
	
	@Test
	public void ctor_IndicatorIdNull_Exception() {
		// arrange, preassert
		exceptionRule.expect(IllegalArgumentException.class);
		// act
		new IndicatorImpl(NAME, null);
	}
}
