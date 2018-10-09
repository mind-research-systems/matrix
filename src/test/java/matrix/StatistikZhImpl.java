package matrix;

import com.opencsv.bean.CsvBindByName;

public class StatistikZhImpl implements Person {
	@CsvBindByName(column = "BFS_NR", required = true)
	private String vorname;
	@CsvBindByName(column = "GEBIET_NAME", required = true)
	private String name;
	@CsvBindByName(column = "THEMA_NAME", required = true)
	private String geburtsdatum;
	@CsvBindByName(column = "SET_NAME", required = true)
	private String geschlecht;
	public String getVorname() {
		return vorname;
	}
	public String getName() {
		return name;
	}
	public String getGeburtsdatum() {
		return geburtsdatum;
	}
	public String getGeschlecht() {
		return geschlecht;
	}
}