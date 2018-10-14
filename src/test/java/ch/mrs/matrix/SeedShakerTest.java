package ch.mrs.matrix;

import static org.junit.Assert.assertNotNull;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import ch.mrs.matrix.feature.FeatureBinding;
import ch.mrs.matrix.seed.Seed;
import ch.mrs.matrix.seed.SeedFactory;
import ch.mrs.matrix.seed.loader.ch.zh.FeatureBindingStatistischesAmtZuerich;

public class SeedShakerTest {
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
	private SeedShaker testee;
	
	@Before 
	public void setup() {
		testee = SeedShaker.getInstance();
	}
	
	@Test
	public void getInstance_NotNull() {
		assertNotNull(testee);
	}
	
		
	@Test
	public void load_Any_NoException() throws IllegalStateException, FileNotFoundException {
		// arrange, act
		List<Seed> seeds = SeedFactory.getInstance().importFromStatistischesAmtZuerich(SeedFactory.RESOURCES + SeedFactory.DATA_ZH_2007_2018);
		List<FeatureBinding> bindings = new ArrayList<>();
		bindings.add(FeatureBindingStatistischesAmtZuerich.AGE);
		bindings.add(FeatureBindingStatistischesAmtZuerich.POPULATION);
		// arrange
		testee.load(seeds, bindings);
	}

}
