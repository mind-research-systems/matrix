package ch.mrs.matrix.seed;

/**
 * A seed is an indicator of statistical dataset.
 * @author donatmueller
 *
 */
public interface Seed {
	String getRegionId();
	String getRegionName();
	String getThemeName();
	String getSetName();
	String getSubsetName();
	String getIndicatorId();
	String getIndicatorName();
	String getIndicatorYear();
	String getIndicatorValue();
	String getUnitShort();
	String getUnitLong();
}
