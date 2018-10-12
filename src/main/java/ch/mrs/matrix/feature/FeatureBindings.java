package ch.mrs.matrix.feature;

public enum FeatureBindings {
	FOO(null);
	
	private final Feature feature;

	private FeatureBindings(String name, String... indicatorIds) {
		this.feature = new FeatureImpl(name);
	}

	public Feature getFeature() {
		return feature;
	}
	
	
}
