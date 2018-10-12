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
		testee = new ConcreteFeature(NAME);
	}

	@Test
	public void getName_EqualsName() {
		// arrange, act
		String result = testee.getName();
		// assert
		assertEquals(NAME,result);
	}
	
	private static class ConcreteFeature extends FeatureImpl {
		ConcreteFeature(String name) {
			super(name);
		}
	}
}
