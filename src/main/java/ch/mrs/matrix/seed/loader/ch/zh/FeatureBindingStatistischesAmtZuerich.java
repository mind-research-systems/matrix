package ch.mrs.matrix.seed.loader.ch.zh;

import java.util.List;

import ch.mrs.matrix.MatrixFeature;
import ch.mrs.matrix.feature.FeatureBinding;
import ch.mrs.matrix.feature.FeatureFactory;
import ch.mrs.matrix.feature.Indicator;
import ch.mrs.matrix.feature.IndicatorProportion;

import static ch.mrs.matrix.MatrixFeature.*;

public enum FeatureBindingStatistischesAmtZuerich implements FeatureBinding {

	POPULATION(CITY_POPULATION,"133"),
	AGE(INDIVIDUAL_AGE, FeatureFactory.getInstance().createIndicatorProportionBuilder() //
			.addIndicatorProportion("Population: Range  0-14 Years old [%]","81",0,14) //
			.addIndicatorProportion("Population: Range 15-19 Years old [%]","83",15,19) //
			.addIndicatorProportion("Population: Range 20-39 Years old [%]","85",20,39) //
			.addIndicatorProportion("Population: Range 40-64 Years old [%]","87",40,64) //
			.addIndicatorProportion("Population: Range 65-79 Years old [%]","89",65,79) //		
			.addIndicatorProportion("Population: Range 80 and more ... [%]","91",80,84) //
			.build());
	private final MatrixFeature matrixFeature;
	private final Indicator indicator;

	private FeatureBindingStatistischesAmtZuerich(MatrixFeature matrixFeature, String indicatorId) {
		this.matrixFeature = matrixFeature;
		this.indicator = FeatureFactory.getInstance().createIndicator(matrixFeature.name(), indicatorId);
	}
	
	private FeatureBindingStatistischesAmtZuerich(MatrixFeature matrixFeature, List<IndicatorProportion> proportions) {
		this.matrixFeature = matrixFeature;
		this.indicator = FeatureFactory.getInstance().createProportionalIndicator(matrixFeature.name(), proportions);
	}

	@Override
	public Indicator getIndicator() {
		return indicator;
	}

	@Override
	public MatrixFeature getMatrixFeature() {
		return matrixFeature;
	}
}
