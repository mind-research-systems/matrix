package ch.mrs.matrix.feature;

import java.util.List;

public interface IndicatorProportionBuilder {
	/**
	 * Adds a range between min and max inclusive for indicator values in percent 
	 * @param name
	 * @param indicatorId id of an indicator of percent type for the values.
	 * @param min the minimum inclusive value to generate
	 * @param max the maximum inclusive value to generate
	 * @return
	 */
	IndicatorProportionBuilder addIndicatorProportion(String name, String indicatorId, int min, int max);
	/**
	 * Adds a
	 * @param name
	 * @param indicatorId
	 * @param total
	 * @return
	 */
//	IndicatorProportionBuilder addAbsolutPartOfTotal(String name, String indicatorId, Indicator total);
//	IndicatorProportionBuilder addRelativePartOfTotal(String name, String indicatorId, Indicator total);
//	IndicatorProportionBuilder addRemainingPartOfTotal(String name, String indicatorId, Indicator total);
	List<IndicatorProportion> build();
}
