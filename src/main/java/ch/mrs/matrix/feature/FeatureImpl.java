package ch.mrs.matrix.feature;

import ch.mrs.matrix.validation.Validate;

class FeatureImpl implements Feature {
	private final String name;

	FeatureImpl(String name) {
		this.name = name;
		Validate.notNull(name);
	}
		
	@Override
	public String getName() {
		return name;
	}
}
