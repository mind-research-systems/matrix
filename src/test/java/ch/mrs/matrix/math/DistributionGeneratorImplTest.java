package ch.mrs.matrix.math;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class DistributionGeneratorImplTest {
	private static final double PERCENT_FEMALE = 50.2;
	private static final double PERCENT_MALE = 49.8;
	private static final double DELTA_ZERO_POINT_TWO = 0.2;
	private static final int NUMBER_OF_VALUES_TO_GENERATE = 1000000;
	private final static Distribution<Sex> FEMALES = MathFactory.getInstance().createDistribution(Sex.FEMALE, PERCENT_FEMALE);
	private final static Distribution<Sex> MALES = MathFactory.getInstance().createDistribution(Sex.MALE, PERCENT_MALE);
	private DistributionGenerator<Sex> testee;
	
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
	@Before
	public void setup() {
		testee = new DistributionGeneratorImpl<Sex>();
	}
	@Test
	public void nextValue_HundretTimes_DistributionMatchesZeroPointOne() {
		// arrange
		testee.add(FEMALES);
		testee.add(MALES);
		testee.validateSumOfDistributionsEqualsOne();
		// act
		for (int i=0; i<100; i++) {
			final Map<Sex,Integer> countForCharacter = createCounters();
			drawMultipleTimesAndAssertDistribution(countForCharacter);
		}
	}
	
	@Test
	public void nextValue_DrawTentousendValues_DistributionMatchesZeroPointOne() {
		// arrange
		testee.add(FEMALES);
		testee.add(MALES);
		testee.validateSumOfDistributionsEqualsOne();
		final Map<Sex,Integer> countForCharacter = createCounters();
		// act
		drawMultipleTimesAndAssertDistribution(countForCharacter);
	}
	
	private void drawMultipleTimesAndAssertDistribution(Map<Sex,Integer> countForCharacter) {
		int numValues = NUMBER_OF_VALUES_TO_GENERATE;
		while (numValues-- > 1) {
			final Sex sex = testee.nextValue();
			if (!countForCharacter.containsKey(sex)) {
				fail(String.format("Value %s out of all ranges %s",sex, countForCharacter.keySet()));
			}
			int count = countForCharacter.get(sex) + 1;
			countForCharacter.put(sex, count);
		}
		assertEquals(0,numValues);
		assertEquals(PERCENT_MALE,100.0 * countForCharacter.get(Sex.MALE) / NUMBER_OF_VALUES_TO_GENERATE,DELTA_ZERO_POINT_TWO);
		assertEquals(PERCENT_FEMALE,100.0 * countForCharacter.get(Sex.FEMALE) / NUMBER_OF_VALUES_TO_GENERATE,DELTA_ZERO_POINT_TWO);
	}

	@Test
	public void add_Distribution100Percent_Validates() {
		// arrange, act
		testee.add(FEMALES);
		testee.add(MALES);
		testee.validateSumOfDistributionsEqualsOne();
	}

	@Test
	public void reset_Distribution100Percent_Validates() {
		// arrange
		List<Distribution<Sex>> distributions = new ArrayList<>();
		distributions.add(FEMALES);
		distributions.add(MALES);
		// act
		testee.reset(distributions);
		testee.validateSumOfDistributionsEqualsOne();
	}

	@Test
	public void getDistributions_MaleAdded_ContainsMale() {
		// arrange
		testee.add(MALES);
		// act
		Collection<Distribution<Sex>> result =  testee.getDistributions();
		// assert
		assertFalse(result.isEmpty());
		assertEquals(1,result.size());
		assertTrue(result.contains(MALES));
	}

	@Test
	public void reset_DistributionNull_Exception() {
		// arrange, preassert
		exceptionRule.expect(IllegalArgumentException.class);
		// act
		testee.reset(null);
	}
	
	@Test
	public void add_DistributionNull_Exception() {
		// arrange, preassert
		exceptionRule.expect(IllegalArgumentException.class);
		// act
		testee.add(null);
	}
	
	@Test
	public void validateSumOfDistributionsEqualsOne_Exception() {
		// arrange, preassert
		exceptionRule.expect(IllegalArgumentException.class);
		// act
		testee.validateSumOfDistributionsEqualsOne();
	}
	
	private Map<Sex,Integer> createCounters() {
		Map<Sex,Integer> countForCategory = new HashMap<>();
		for (Distribution<Sex> d : testee.getDistributions()) {
			countForCategory.put(d.getCategory(), 0);
			
		}
		return countForCategory;
	}
}
