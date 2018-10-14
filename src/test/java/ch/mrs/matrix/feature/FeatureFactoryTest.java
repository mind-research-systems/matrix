package ch.mrs.matrix.feature;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import ch.mrs.matrix.math.MathFactory;
import ch.mrs.matrix.math.Range;

public class FeatureFactoryTest {
	private final static String NAME = "height";
	private final static String ID = "15";
	private final static List<IndicatorProportion> PROPORTIONS = new ArrayList<>();
	private final static Range<Integer> RANGE = MathFactory.getInstance().createRange(3, 9);
	
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
	private FeatureFactory testee;
	
	@Before 
	public void setup() {
		testee = FeatureFactory.getInstance();
	}
	
	@Test
	public void getInstance_NotNull() {
		assertNotNull(testee);
	}
	
		
	@Test
	public void createIndicator_Any_NotNull() {
		// arrange, act
		Indicator result = testee.createIndicator(NAME, ID);
		// assert
		assertNotNull(result);
	}
	
	@Test
	public void createProportionalIndicator_Any_NotNull() {
		// arrange, act
		ProportionalIndicator result = testee.createProportionalIndicator(NAME, Collections.emptyList());
		// assert
		assertNotNull(result);
	}
	
	@Test
	public void createIndicatorProportionBuilder_Any_NotNull() {
		// arrange, act
		IndicatorProportionBuilder result = testee.createIndicatorProportionBuilder();
		// assert
		assertNotNull(result);
	}
	
	@Test
	public void createIndicatorProportion_Any_NotNull() {
		// arrange, act
		IndicatorProportion result = testee.createIndicatorProportion(NAME, ID, RANGE);
		// assert
		assertNotNull(result);
	}
	
	@Test
	public void createIndicator_NameNull_Exception() {
		// arrrange, preassert
		exceptionRule.expect(IllegalArgumentException.class);
		// act
		testee.createIndicator(null, ID);
	}
	
	@Test
	public void createIndicator_IdNull_Exception() {
		// arrrange, preassert
		exceptionRule.expect(IllegalArgumentException.class);
		// act
		testee.createIndicator(NAME, null);
	}
	
	@Test
	public void createProportionalIndicator_NameNull_Exception() {
		// arrrange, preassert
		exceptionRule.expect(IllegalArgumentException.class);
		// act
		testee.createProportionalIndicator(null, PROPORTIONS);
	}
	
	@Test
	public void createProportionalIndicator_ProportionsNull_Exception() {
		// arrrange, preassert
		exceptionRule.expect(IllegalArgumentException.class);
		// act
		testee.createProportionalIndicator(NAME, null);
	}
	
	@Test
	public void createIndicatorProportion_NameNull_Exception() {
		// arrrange, preassert
		exceptionRule.expect(IllegalArgumentException.class);
		// act
		testee.createIndicatorProportion(null,ID, RANGE);
	}
	
	@Test
	public void createIndicatorProportion_IdNull_Exception() {
		// arrrange, preassert
		exceptionRule.expect(IllegalArgumentException.class);
		// act
		testee.createIndicatorProportion(NAME,null, RANGE);
	}
	
	@Test
	public void createIndicatorProportion_RangeNull_Exception() {
		// arrrange, preassert
		exceptionRule.expect(IllegalArgumentException.class);
		// act
		testee.createIndicatorProportion(NAME,ID, null);
	}
}
