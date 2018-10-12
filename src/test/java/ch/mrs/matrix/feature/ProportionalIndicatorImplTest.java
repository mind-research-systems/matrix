package ch.mrs.matrix.feature;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import ch.mrs.matrix.math.MathFactory;

/**
 * 
 * @author donatmueller
 *
 */
public class ProportionalIndicatorImplTest {
	private static final String NAME = "age";
	private static final List<IndicatorProportion> PROPORTIONS = new ArrayList<>();
	private static final double[] VALUES = new double[] {15.9,5.0,24.9,35.7,13.2,5.3}; 
	private ProportionalIndicator testee;
	
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();

	@Before
	public void setup() {
		testee = new ProportionalIndicatorImpl(NAME, PROPORTIONS);
	}

	@Test
	public void getIndicatorId_EqualsProportionalId() {
		// arrange, act
		String result = testee.getIndicatorId();
		// assert
		assertEquals(Indicator.PROPORTIONAL_INDICATOR_ID,result);
	}
	
	@Test
	public void getProportions_EqualsProportions() {
		// arrange, act
		Object result = testee.getProportions();
		// assert
		assertEquals(PROPORTIONS,result);
	}
	
	@Test
	public void getValue_Exception() {
		// arrange, preassert
		exceptionRule.expect(IllegalArgumentException.class);
		// act
		testee.getValue();
	}
	
	@Test
	public void loadValue_MismatchInNumberOfValues_Exception() {
		// arrange preassert
		exceptionRule.expect(IllegalArgumentException.class);
		// act
		testee.loadValue(VALUES);
	}
	
	@Test
	public void getValue_AfterLoadValue_Produces500Values() {
		// arrange
		testee = new ProportionalIndicatorImpl("Age", createProportions());
		testee.loadValue(VALUES);
		// act
		int numValues = 500;
		while (numValues-- > 1) {
			testee.getValue();
		}
		assertEquals(0,numValues);
	}
	
	@Test
	public void ctor_NameNull_Exception() {
		// arrange, preassert
		exceptionRule.expect(IllegalArgumentException.class);
		// act
		new ProportionalIndicatorImpl(null, PROPORTIONS);
	}
	
	@Test
	public void ctor_ProportionsNull_Exception() {
		// arrange, preassert
		exceptionRule.expect(IllegalArgumentException.class);
		// act
		new ProportionalIndicatorImpl(NAME, null);
	}

	/**
	 * Feature: Population: Range  0-14 Years old [%], Id: 81 = 15.9
	 * Feature: Population: Range 15-19 Years old [%], Id: 83 =  5.0
	 * Feature: Population: Range 20-39 Years old [%], Id: 85 = 24.9
	 * Feature: Population: Range 40-64 Years old [%], Id: 87 = 35.7
	 * Feature: Population: Range 65-79 Years old [%], Id: 89 = 13.2
	 * Feature: Population: Range 80 u.m.-Jähr. [%], Id: 91 =  5.3
	 * @return
	 */
	private List<IndicatorProportion> createProportions() {
		List<IndicatorProportion> proportions = new ArrayList<>();
		addIndicatorProportion(proportions,"Population: Range  0-14 Years old [%]","81",0,14);
		addIndicatorProportion(proportions,"Population: Range 15-19 Years old [%]","83",15,19);
		addIndicatorProportion(proportions,"Population: Range 20-39 Years old [%]","85",20,39);
		addIndicatorProportion(proportions,"Population: Range 40-64 Years old [%]","87",40,64);
		addIndicatorProportion(proportions,"Population: Range 65-79 Years old [%]","89",65,79);
		addIndicatorProportion(proportions,"Population: Range 80 and more ... [%]","91",80,150);
		return proportions;
	}
	
	private void addIndicatorProportion(List<IndicatorProportion> proportions, String name, String id, int min, int max) {
		proportions.add(new IndicatorProportionImpl(name, id, MathFactory.createRange(min, max)));
	}
} 
