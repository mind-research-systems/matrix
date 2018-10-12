package ch.mrs.matrix.feature;

import ch.mrs.matrix.validation.Validate;

public class IndicatorImpl extends FeatureImpl implements Indicator {
	private final String indicatorId;
	private Integer value = null;
	public IndicatorImpl(String name, String indicatorId) {
		super(name);
		this.indicatorId = indicatorId;
		Validate.notNull(indicatorId);
	}
	
	@Override
	public String getIndicatorId() {
		return indicatorId;
	}
	
	@Override
	public int getValue() {
		Validate.notNull(value);
		int result = value;
		value = null;
		return result;
	}
	
	@Override
	public void loadValue(int value) {
		this.value = value;
	}
}
