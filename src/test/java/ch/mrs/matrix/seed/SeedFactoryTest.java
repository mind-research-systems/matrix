package ch.mrs.matrix.seed;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

public class SeedFactoryTest  {
	private static final String HORGEN = "Horgen";
	private final static String BFS_HORGEN = "295";
	private static final String HINWIL = "Hinwil";
	private final static String BFS_HINWIL = "117";
	private final static String INDIKATOR_ID_RESTAURANTS = "304";
	private final static String INDIKATOR_ID_BEVOELKERUNG = "206";
	private final static String INDIKATOR_ID_WOHNEN_ANTEIL = "167";
	private final static int INDIKATOR_ID_RESTAURANTS_SIZE = 390;
	private final static int INDIKATOR_ID_BEVOELKERUNG_SIZE = 782;
	private final static int INDIKATOR_ID_WOHNEN_ANTEIL_SIZE = 964;

	private SeedFactory testee;
	
	@Before
	public void setup() {
		testee = SeedFactory.getInstance();
	}
	
	@Test
	public void getInstance_NotNull() {
		assertNotNull(testee);
	}

	@Test
	public void importFromStatistischesAmtZuerich_WithZhData_Parsed3602() throws IOException {
		// act
		List<Seed> result = testee.importFromStatistischesAmtZuerich(SeedFactory.RESOURCES + SeedFactory.DATA_ZH_2018);
		// assert
		assertNotNull(result);
		assertEquals(SeedFactory.DATA_ZH_2018_SIZE,result.size());
	}

	@Test
	public void importFromStatistischesAmtZuerich_WithZhData_FirstAllFieldsSet() throws IOException {
		// act
		List<Seed> result = testee.importFromStatistischesAmtZuerich(SeedFactory.RESOURCES + SeedFactory.DATA_ZH_2018);
		// assert
		assertNotNull(result);
		assertFalse(result.isEmpty());
		assertAllFieldsSet(result.get(0));
	}

	@Test
	public void importFromStatistischesAmtZuerich_WithZhDataFilterHorgen_AllGebietHorgen() throws IOException {
		// act
		List<Seed> resultsAll = testee.importFromStatistischesAmtZuerich(SeedFactory.RESOURCES + SeedFactory.DATA_ZH_2007_2018);
		List<Seed> resultsFiltered = resultsAll.stream().filter(x -> BFS_HORGEN.equals(x.getRegionId())).collect(Collectors.toList());
		// assert
		assertNotNull(resultsAll);
		assertEquals(SeedFactory.DATA_ZH_2007_2018_SIZE,resultsAll.size());
		assertFalse(resultsFiltered.isEmpty());
		assertEquals(560,resultsFiltered.size());
		Map<String,String> features = new HashMap<>();
		System.out.println("Gebiet: " + HORGEN);
		for (int i=0;i<resultsFiltered.size();i++) {
			Seed d = resultsFiltered.get(i);
			assertEquals(HORGEN, d.getRegionName());
			String name = d.getIndicatorName();
			String value = d.getIndicatorValue();
			if (value != null && !features.containsKey(name)) {
				System.out.println(String.format("Feature: %s, Id: %s = %s", name, d.getIndicatorId(), value));
				features.put(name, value);
				
			}
		}
	}
	@Test
	public void importFromStatistischesAmtZuerich_WithZhDataFilterHinwil_AllGebietHorgen() throws IOException {
		// act
		List<Seed> resultsAll = testee.importFromStatistischesAmtZuerich(SeedFactory.RESOURCES + SeedFactory.DATA_ZH_2007_2018);
		List<Seed> resultsFiltered = resultsAll.stream().filter(x -> BFS_HINWIL.equals(x.getRegionId())).collect(Collectors.toList());
		// assert
		assertNotNull(resultsAll);
		assertEquals(SeedFactory.DATA_ZH_2007_2018_SIZE,resultsAll.size());
		assertFalse(resultsFiltered.isEmpty());
		assertEquals(880,resultsFiltered.size());
		Map<String,String> features = new HashMap<>();
		System.out.println("Gebiet: " + HINWIL);
		for (int i=0;i<resultsFiltered.size();i++) {
			Seed d = resultsFiltered.get(i);
			assertEquals(HINWIL, d.getRegionName());
			String name = d.getIndicatorName();
			String value = d.getIndicatorValue();
			if (value != null && !features.containsKey(name)) {
				System.out.println(String.format("Feature: %s, Id: %s = %s", name, d.getIndicatorId(), value));
				features.put(name, value);
				
			}
		}
	}
	

	@Test
	public void importFromStatistischesAmtZuerich_WithZhDataFilterRestaurants_AllGebietHorgen() throws IOException {
		importFromStatistischesAmtZuerich_WithZhDataFilterById_NotEmpty(INDIKATOR_ID_RESTAURANTS,INDIKATOR_ID_RESTAURANTS_SIZE);
	}
	
	@Test
	public void importFromStatistischesAmtZuerich_WithZhDataFilterBevoelkerung_AllGebietHorgen() throws IOException {
		importFromStatistischesAmtZuerich_WithZhDataFilterById_NotEmpty(INDIKATOR_ID_BEVOELKERUNG,INDIKATOR_ID_BEVOELKERUNG_SIZE);
	}
	
	@Test
	public void importFromStatistischesAmtZuerich_WithZhDataFilterWohnenAnteil_AllGebietHorgen() throws IOException {
		importFromStatistischesAmtZuerich_WithZhDataFilterById_NotEmpty(INDIKATOR_ID_WOHNEN_ANTEIL,INDIKATOR_ID_WOHNEN_ANTEIL_SIZE);
	}
	
	private void importFromStatistischesAmtZuerich_WithZhDataFilterById_NotEmpty(String indikator_id, int countExpected) throws IllegalStateException, FileNotFoundException {
		// act
		List<Seed> resultsAll = testee.importFromStatistischesAmtZuerich(SeedFactory.RESOURCES + SeedFactory.DATA_ZH_2007_2018);
		List<Seed> resultsFiltered = resultsAll.stream().filter(x -> indikator_id.equals(x.getIndicatorId())).collect(Collectors.toList());
		// assert
		assertNotNull(resultsAll);
		assertEquals(SeedFactory.DATA_ZH_2007_2018_SIZE,resultsAll.size());
		assertFalse(String.format("Indikator '%s' not found.", indikator_id), resultsFiltered.isEmpty());
		assertEquals(countExpected,resultsFiltered.size());
	}
	
	private void assertAllFieldsSet(Seed p) {
		assertNotNull(p.getRegionId());
		assertNotNull(p.getRegionName());
		assertNotNull(p.getThemeName());
		assertNotNull(p.getSetName());
		assertNotNull(p.getSubsetName());
		assertNotNull(p.getIndicatorId());
		assertNotNull(p.getIndicatorName());
		assertNotNull(p.getIndicatorYear());
		assertNotNull(p.getIndicatorValue());
		assertNotNull(p.getUnitShort());
		assertNotNull(p.getUnitLong());
	}
}
