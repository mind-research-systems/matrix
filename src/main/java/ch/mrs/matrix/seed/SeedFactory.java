package ch.mrs.matrix.seed;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import ch.mrs.matrix.seed.loader.ch.zh.StatistischesAmtZuerich;

public class SeedFactory {
	public final static char SEPARATOR = ';';
	public final static String RESOURCES = "./src/main/resources/";
	public final static String DATA_ZH_2018 = "data_zh-2018.csv";
	public final static String DATA_ZH_2007_2018 = "data_zh-2007-2018.csv";
	public final static int DATA_ZH_2018_SIZE = 3206;
	public final static int DATA_ZH_2007_2018_SIZE = 170883;

	private SeedFactory() {
		// factory
	}

	public static List<Seed> importFromStatistischesAmtZuerich(String resource) throws IllegalStateException, FileNotFoundException {
		CsvToBean<Seed> csvToBean = new CsvToBeanBuilder<Seed>(new FileReader(resource)).withSeparator(SEPARATOR).withType(StatistischesAmtZuerich.class).build();
		return csvToBean.parse();
	}
}