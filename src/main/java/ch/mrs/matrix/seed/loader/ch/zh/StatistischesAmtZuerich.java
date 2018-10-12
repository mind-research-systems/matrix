package ch.mrs.matrix.seed.loader.ch.zh;

import com.opencsv.bean.CsvBindByName;

import ch.mrs.matrix.seed.Seed;

/**
 * Description: Population indicators for canton zuerich in switzerland
 * Publisher: Kanton Zürich, Direktion der Justiz und des Innern, Statistisches Amt
 * DataSource: https://statistik.zh.ch/internet/justiz_inneres/statistik/de/daten/gemeindeportraet_kanton_zuerich.html
 * 
 * Caution: To create new data files preserve the header row of an existing data file as at time of development the csv files
 * downloaded from the data source produce exceptions in the csv import unless replacing the header row.
 * @author donatmueller
 *
 */
public class StatistischesAmtZuerich implements Seed {
	public final static String BFS_NR = "BFS_NR" ;
	public final static String GEBIET_NAME = "GEBIET_NAME";
	public final static String THEMA_NAME = "THEMA_NAME";
	public final static String SET_NAME = "SET_NAME";
	public final static String SUBSET_NAME = "SUBSET_NAME";
	public final static String INDIKATOR_ID = "INDIKATOR_ID";
	public final static String INDIKATOR_NAME = "INDIKATOR_NAME";
	public final static String INDIKATOR_JAHR = "INDIKATOR_JAHR";
	public final static String INDIKATOR_VALUE = "INDIKATOR_VALUE";
	public final static String EINHEIT_KURZ = "EINHEIT_KURZ";
	public final static String EINHEIT_LANG = "EINHEIT_LANG";
	
	@CsvBindByName(column = BFS_NR, required = true)
	private String bfsNr;
	@CsvBindByName(column = GEBIET_NAME, required = true)
	private String gebietName;
	@CsvBindByName(column = THEMA_NAME, required = true)
	private String themaName;
	@CsvBindByName(column = SET_NAME, required = true)
	private String setName;
	@CsvBindByName(column = SUBSET_NAME, required = true)
	private String subsetName;
	@CsvBindByName(column = INDIKATOR_ID, required = true)
	private String indikatorId;
	@CsvBindByName(column = INDIKATOR_NAME, required = true)
	private String indikatorName;
	@CsvBindByName(column = INDIKATOR_JAHR, required = true)
	private String indikatorJahr;
	@CsvBindByName(column = INDIKATOR_VALUE, required = true)
	private String indikatorValue;
	@CsvBindByName(column = EINHEIT_KURZ, required = true)
	private String einheitKurz;
	@CsvBindByName(column = EINHEIT_LANG, required = true)
	private String einheitLang;
	
	public StatistischesAmtZuerich() {
		// bean ctor
	}

	@Override
	public String getRegionId() {
		return bfsNr;
	}

	@Override
	public String getRegionName() {
		return gebietName;
	}

	@Override
	public String getThemeName() {
		return themaName;
	}

	@Override
	public String getSetName() {
		return setName;
	}

	@Override
	public String getSubsetName() {
		return subsetName;
	}

	@Override
	public String getIndicatorId() {
		return indikatorId;
	}

	@Override
	public String getIndicatorName() {
		return indikatorName;
	}

	@Override
	public String getIndicatorYear() {
		return indikatorJahr;
	}

	@Override
	public String getIndicatorValue() {
		return indikatorValue;
	}

	@Override
	public String getUnitShort() {
		return einheitKurz;
	}

	@Override
	public String getUnitLong() {
		return einheitLang;
	}
}
