package ch.mrs.matrix.feature;

public interface Indicator extends Feature {
	public static String PROPORTIONAL_INDICATOR_ID = "#multivalued#";
	String getIndicatorId();
	int getValue();
	void loadValue(int value);
}
