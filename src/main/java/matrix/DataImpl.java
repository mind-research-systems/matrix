package matrix;

import com.opencsv.bean.CsvBindByName;

public class DataImpl implements Data {
	// ;BFS_NR;GEBIET_NAME;THEMA_NAME;SET_NAME;SUBSET_NAME;INDIKATOR_ID;INDIKATOR_NAME;INDIKATOR_JAHR;INDIKATOR_VALUE;EINHEIT_KURZ;EINHEIT_LANG;

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
	
	public DataImpl() {
		// bean ctor
	}

	@Override
	public String getBfsNr() {
		return bfsNr;
	}

	@Override
	public String getGebietName() {
		return gebietName;
	}

	@Override
	public String getThemaName() {
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
	public String getIndikatorId() {
		return indikatorId;
	}

	@Override
	public String getIndikatorName() {
		return indikatorName;
	}

	@Override
	public String getIndikatorJahr() {
		return indikatorJahr;
	}

	@Override
	public String getIndikatorValue() {
		return indikatorValue;
	}

	@Override
	public String getEinheitKurz() {
		return einheitKurz;
	}

	@Override
	public String getEinheitLang() {
		return einheitLang;
	}
}
