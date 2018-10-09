package matrix;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Test;

public class FactoryTest {
	private static final String HORGEN = "Horgen";
	private final static String BFS_HORGEN = "295";
	private final static String INDIKATOR_ID_RESTAURANTS = "304";
	private final static String INDIKATOR_ID_BEVOELKERUNG = "206";
	private final static String INDIKATOR_ID_WOHNEN_ANTEIL = "167";
	private final static int INDIKATOR_ID_RESTAURANTS_SIZE = 390;
	private final static int INDIKATOR_ID_BEVOELKERUNG_SIZE = 782;
	private final static int INDIKATOR_ID_WOHNEN_ANTEIL_SIZE = 964;

	@Test
	public void parseDataZhCsv_WithZhData_Parsed3602() throws IOException {
		// act
		List<Data> result = Factory.parseDataZhCsv(Factory.RESOURCES + Factory.DATA_ZH_2018);
		// assert
		assertNotNull(result);
		assertEquals(Factory.DATA_ZH_2018_SIZE,result.size());
	}

	@Test
	public void parseDataZhCsv_WithZhData_FirstAllFieldsSet() throws IOException {
		// act
		List<Data> result = Factory.parseDataZhCsv(Factory.RESOURCES + Factory.DATA_ZH_2018);
		// assert
		assertNotNull(result);
		assertFalse(result.isEmpty());
		assertAllFieldsSet(result.get(0));
	}

	@Test
	public void parseDataZhCsv_WithZhDataFilterHorgen_AllGebietHorgen() throws IOException {
		// act
		List<Data> resultsAll = Factory.parseDataZhCsv(Factory.RESOURCES + Factory.DATA_ZH_2007_2018);
		List<Data> resultsFiltered = resultsAll.stream().filter(x -> BFS_HORGEN.equals(x.getBfsNr())).collect(Collectors.toList());
		// assert
		assertNotNull(resultsAll);
		assertEquals(Factory.DATA_ZH_2007_2018_SIZE,resultsAll.size());
		assertFalse(resultsFiltered.isEmpty());
		assertEquals(560,resultsFiltered.size());
		Map<String,String> features = new HashMap<>();
		System.out.println("Gebiet: " + HORGEN);
		for (int i=0;i<resultsFiltered.size();i++) {
			Data d = resultsFiltered.get(i);
			assertEquals(HORGEN, d.getGebietName());
			String name = d.getIndikatorName();
			String value = d.getIndikatorValue();
			if (value != null && !features.containsKey(name)) {
				System.out.println(String.format("Feature: %s, Id: %s = %s", name, d.getIndikatorId(), value));
				features.put(name, value);
				
			}
		}
	}
	

	@Test
	public void parseDataZhCsv_WithZhDataFilterRestaurants_AllGebietHorgen() throws IOException {
		parseDataZhCsv_WithZhDataFilterById_NotEmpty(INDIKATOR_ID_RESTAURANTS,INDIKATOR_ID_RESTAURANTS_SIZE);
	}
	
	@Test
	public void parseDataZhCsv_WithZhDataFilterBevoelkerung_AllGebietHorgen() throws IOException {
		parseDataZhCsv_WithZhDataFilterById_NotEmpty(INDIKATOR_ID_BEVOELKERUNG,INDIKATOR_ID_BEVOELKERUNG_SIZE);
	}
	
	@Test
	public void parseDataZhCsv_WithZhDataFilterWohnenAnteil_AllGebietHorgen() throws IOException {
		parseDataZhCsv_WithZhDataFilterById_NotEmpty(INDIKATOR_ID_WOHNEN_ANTEIL,INDIKATOR_ID_WOHNEN_ANTEIL_SIZE);
	}
	
	private void parseDataZhCsv_WithZhDataFilterById_NotEmpty(String indikator_id, int countExpected) throws IllegalStateException, FileNotFoundException {
		// act
		List<Data> resultsAll = Factory.parseDataZhCsv(Factory.RESOURCES + Factory.DATA_ZH_2007_2018);
		List<Data> resultsFiltered = resultsAll.stream().filter(x -> indikator_id.equals(x.getIndikatorId())).collect(Collectors.toList());
		// assert
		assertNotNull(resultsAll);
		assertEquals(Factory.DATA_ZH_2007_2018_SIZE,resultsAll.size());
		assertFalse(String.format("Indikator '%s' not found.", indikator_id), resultsFiltered.isEmpty());
		assertEquals(countExpected,resultsFiltered.size());
	}
	
	private void assertAllFieldsSet(Data p) {
		assertNotNull(p.getBfsNr());
		assertNotNull(p.getGebietName());
		assertNotNull(p.getThemaName());
		assertNotNull(p.getSetName());
		assertNotNull(p.getSubsetName());
		assertNotNull(p.getIndikatorId());
		assertNotNull(p.getIndikatorName());
		assertNotNull(p.getIndikatorJahr());
		assertNotNull(p.getIndikatorValue());
		assertNotNull(p.getEinheitKurz());
		assertNotNull(p.getEinheitLang());
	}
}
