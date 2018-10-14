package ch.mrs.matrix.feature;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import ch.mrs.matrix.math.MathFactory;
import ch.mrs.matrix.math.Range;

/**
 * 
 * @author donatmueller
 *
 */
public class ProportionalIndicatorImplTest {
	private static final double DELTA_ZERO_POINT_TWO = 0.2;
	private static final int ONE_MILLION = 1000000;
	private static final String NAME = "age";
	private final static double AGE_00_TO_14 = 15.9;
	private final static double AGE_15_TO_19 = 5.0;
	private final static double AGE_20_TO_39 = 24.9;
	private final static double AGE_40_TO_64 = 35.7;
	private final static double AGE_65_TO_79 = 13.2;
	private final static double AGE_80_NMORE = 5.3;
	
	private static final List<IndicatorProportion> PROPORTIONS = new ArrayList<>();
	private static final Double[] VALUES = new Double[] {AGE_00_TO_14, AGE_15_TO_19, AGE_20_TO_39, AGE_40_TO_64, AGE_65_TO_79, AGE_80_NMORE}; 
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
	public void nextValue_HundretTimes_DistributedDeltaLessThanZeroPointTwo() {
		// act
		for (int i=0; i<100; i++) {
			getValue_AfterLoadValueProduceOneMillionValues_DistributedDeltaLessThanZeroPointTwo();
		}
	}
	
	@Test
	public void getValue_AfterLoadValueProduceOneMillionValues_DistributedDeltaLessThanZeroPointTwo() {
		// arrange
		final List<IndicatorProportion> distribution = createNonUniformDistributionSpecification();
		testee = new ProportionalIndicatorImpl("Age", distribution);
		testee.loadValue(VALUES);
		// act
		final Map<Range<Integer>,Integer> countForRanges = createCounters(distribution);
		int numValues = ONE_MILLION;
		while (numValues-- > 1) {
			final int age = testee.getValue();
			boolean hit = false;
			for (Range<Integer> range : countForRanges.keySet()) {
				if (range.inside(age)) {
					hit = true;
					int count = countForRanges.get(range) + 1;
					countForRanges.put(range, count);
					break;
				}
			}
			if (!hit) {				
				fail(String.format("Age %s out of all ranges %s",age, countForRanges.keySet()));
			}
		}
		assertEquals(0,numValues);
		int index = 0;
		while (index < distribution.size()) {
			IndicatorProportion p = distribution.get(index);
			assertEquals(p.getName(),VALUES[index],100.0 * countForRanges.get(p.getRange()) / ONE_MILLION,DELTA_ZERO_POINT_TWO);
			index++;
		}
	}
	
	
	private Map<Range<Integer>,Integer> createCounters(List<IndicatorProportion> distributions) {
		Map<Range<Integer>,Integer> countForCategory = new HashMap<>();
		for (IndicatorProportion distribution : distributions) {
			countForCategory.put(distribution.getRange(), 0);
			
		}
		return countForCategory;
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
	 * Non uniform ranges of distribution for the feature age of a population 
	 * Feature: Population: Range  0-14 Years old [%], Id: 81 = 15.9
	 * Feature: Population: Range 15-19 Years old [%], Id: 83 =  5.0
	 * Feature: Population: Range 20-39 Years old [%], Id: 85 = 24.9
	 * Feature: Population: Range 40-64 Years old [%], Id: 87 = 35.7
	 * Feature: Population: Range 65-79 Years old [%], Id: 89 = 13.2
	 * Feature: Population: Range 80 u.m.-Jähr. [%], Id: 91 =  5.3
	 * @return
	 */
	private List<IndicatorProportion> createNonUniformDistributionSpecification() {
		List<IndicatorProportion> proportions = new ArrayList<>();
		addIndicatorProportion(proportions,"Population: Range  0-14 Years old [%]","81",0,14);
		addIndicatorProportion(proportions,"Population: Range 15-19 Years old [%]","83",15,19);
		addIndicatorProportion(proportions,"Population: Range 20-39 Years old [%]","85",20,39);
		addIndicatorProportion(proportions,"Population: Range 40-64 Years old [%]","87",40,64);
		addIndicatorProportion(proportions,"Population: Range 65-79 Years old [%]","89",65,79);
		addIndicatorProportion(proportions,"Population: Range 80 and more ... [%]","91",80,84);
		return proportions;
	}
	
	private void addIndicatorProportion(List<IndicatorProportion> proportions, String name, String id, int min, int max) {
		proportions.add(new IndicatorProportionImpl(name, id, MathFactory.getInstance().createRange(min, max)));
	}
} 
