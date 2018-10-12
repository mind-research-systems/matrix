package ch.mrs.matrix.feature;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class FeatureImplTest {
	private static final String NAME = "age";
	private Feature testee;
	
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();

	@Before
	public void setup() {
		testee = new FeatureImpl(NAME);
	}

	@Test
	public void getName_EqualsName() {
		// arrange, act
		String result = testee.getName();
		// assert
		assertEquals(NAME,result);
	}
	
	@Test
	public void ctor_NameNull_Exception() {
		// arrange, preassert
		exceptionRule.expect(IllegalArgumentException.class);
		// act
		new FeatureImpl(null);
	}

}
