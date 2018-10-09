package matrix;

import com.opencsv.bean.CsvBindByName;

public class PersonImpl implements Person {
	@CsvBindByName
	private String vorname;
	@CsvBindByName
	private String name;
	@CsvBindByName
	private String geburtsdatum;
	@CsvBindByName
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