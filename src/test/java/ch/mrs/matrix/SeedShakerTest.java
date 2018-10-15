package ch.mrs.matrix;

import static org.junit.Assert.assertNotNull;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import ch.mrs.matrix.seed.Seed;
import ch.mrs.matrix.seed.SeedFactory;
import ch.mrs.matrix.seed.loader.ch.zh.FeatureBindingStatistischesAmtZuerich;
import ch.mrs.matrix.seed.loader.ch.zh.StatistischesAmtZuerich;

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
		List<Seed> seeds = SeedFactory.getInstance().load(SeedFactory.RESOURCES + SeedFactory.DATA_ZH_2007_2018, StatistischesAmtZuerich.class);
		// arrange
		testee.load(seeds, Arrays.asList(FeatureBindingStatistischesAmtZuerich.values()));
	}

}
