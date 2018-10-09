package matrix;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class Factory {
	public final static char SEPARATOR = ';';
	public final static String RESOURCES = "./src/main/resources/";
	public final static String DATA_ZH_2018 = "data_zh-2018.csv";
	public final static String DATA_ZH_2007_2018 = "data_zh-2007-2018.csv";
	public final static int DATA_ZH_2018_SIZE = 3206;
	public final static int DATA_ZH_2007_2018_SIZE = 170883;

	private Factory() {
		// factory
	}

	public static List<Data> parseDataZhCsv(String resource) throws IllegalStateException, FileNotFoundException {
		CsvToBean<Data> csvToBean = new CsvToBeanBuilder<Data>(new FileReader(resource)).withSeparator(SEPARATOR).withType(DataImpl.class).build();
		return csvToBean.parse();
	}
}
