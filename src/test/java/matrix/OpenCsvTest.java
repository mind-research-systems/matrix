package matrix;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class OpenCsvTest {
	public final static String TEST_RESOURCES = "./src/test/resources/";
	private final static String TEST_CSV_BASICS = "test.csv";
	private final static String TEST_DATA_ZH_HEADER_PERSON_CONTENT = "statistik_zh.csv";
	private final static String TEST_DATA_ZH_HEADER_AND_CONTENT = "statistik_zh1.csv";
	public final static String TEST_DATA_ZH = "data_zh-test.csv";

	@Test
	public void parseCsv_TestCsvBasics_AlleVornamenKorrekt() throws IllegalStateException, FileNotFoundException {
		// arrange & act
		List<Person> result = parseHeadersPersonCsv(TEST_RESOURCES + TEST_CSV_BASICS);
		// assert
		assertNotNull(result);
		assertFalse(result.isEmpty());
		assertEquals(3, result.size());
		List<String> vornamen = result.stream().map(Person::getVorname).distinct().collect(Collectors.toList());
		assertTrue(vornamen.contains("Peter"));
		assertTrue(vornamen.contains("Sarah"));
		assertTrue(vornamen.contains("Rolf"));
		
	}
	
	@Test
	public void parseCsv_StatistikZh_AlleVornamenKorrekt() throws IllegalStateException, FileNotFoundException {
		// arrange & act
		List<Person> result = parseHeadersStatistikZhCsv(TEST_RESOURCES + TEST_DATA_ZH_HEADER_PERSON_CONTENT);
		// assert
		assertNotNull(result);
		assertFalse(result.isEmpty());
		assertEquals(3, result.size());
		List<String> vornamen = result.stream().map(Person::getVorname).collect(Collectors.toList());
		assertEquals(3, vornamen.size());
		assertTrue(vornamen.contains("Peter"));
		assertTrue(vornamen.contains("Sarah"));
		assertTrue(vornamen.contains("Rolf"));
	}
	
	@Test
	public void parseCsv_StatistikZh_FirstAllFieldsSet() throws IllegalStateException, FileNotFoundException {
		// arrange & act
		List<Person> result = parseHeadersStatistikZhCsv(TEST_RESOURCES + TEST_DATA_ZH_HEADER_PERSON_CONTENT);
		// assert
		assertNotNull(result);
		assertFalse(result.isEmpty());
		assertAllFieldsSet(result.get(0));
	}
	
	@Test
	public void parseCsv_StatistikZh1_VornameIs1() throws IllegalStateException, FileNotFoundException {
		// arrange & act
		List<Person> result = parseHeadersStatistikZhCsv(TEST_RESOURCES + TEST_DATA_ZH_HEADER_AND_CONTENT);
		// assert
		assertNotNull(result);
		assertFalse(result.isEmpty());
		assertEquals(3, result.size());
		List<String> vornamen = result.stream().map(Person::getVorname).collect(Collectors.toList());
		assertEquals(3, vornamen.size());
		assertTrue(vornamen.contains("1"));
	}
	
	@Test
	public void parseCsv_StatistikZh1_FirstAllFieldsSet() throws IllegalStateException, FileNotFoundException {
		// arrange & act
		List<Person> result = parseHeadersStatistikZhCsv(TEST_RESOURCES + TEST_DATA_ZH_HEADER_AND_CONTENT);
		// assert
		assertNotNull(result);
		assertFalse(result.isEmpty());
		assertAllFieldsSet(result.get(0));
	}
	
	
	@Test
	public void parseCsv_StatistikZhWithRealDataButHeaderReplaced_Parsed3206() throws IllegalStateException, FileNotFoundException {
		// arrange & act
		List<Person> result = parseHeadersStatistikZhCsv(TEST_RESOURCES + TEST_DATA_ZH);
		// assert
		assertNotNull(result);
		assertFalse(result.isEmpty());
		assertEquals(Factory.DATA_ZH_2018_SIZE, result.size());
	}
	
	@Test
	public void parseCsv_StatistikZhWithRealDataButHeaderReplaced_FirstAllFieldsSet() throws IllegalStateException, FileNotFoundException {
		// arrange & act
		List<Person> result = parseHeadersStatistikZhCsv(TEST_RESOURCES + TEST_DATA_ZH);
		// assert
		assertNotNull(result);
		assertFalse(result.isEmpty());
		assertAllFieldsSet(result.get(0));
	}
	
	
	static void assertAllFieldsSet(Person p) {
		assertNotNull(p.getVorname());
		assertNotNull(p.getName());
		assertNotNull(p.getGeburtsdatum());
		assertNotNull(p.getGeschlecht());
	}
	
	private List<Person>  parseHeadersPersonCsv(String resource) throws IllegalStateException, FileNotFoundException {
		CsvToBean<Person> csvToBean = new CsvToBeanBuilder<Person>(new FileReader(resource)).withSeparator(Factory.SEPARATOR).withType(PersonImpl.class).build();
		return csvToBean.parse();
	}
	private List<Person>  parseHeadersStatistikZhCsv(String resource) throws IllegalStateException, FileNotFoundException {
		CsvToBean<Person> csvToBean = new CsvToBeanBuilder<Person>(new FileReader(resource)).withSeparator(Factory.SEPARATOR).withType(StatistikZhImpl.class).build();
		return csvToBean.parse();
	}
}
