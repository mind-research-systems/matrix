package ch.mrs.matrix.feature;

import ch.mrs.matrix.MatrixFeature;

/**
 * Binds a feature of the Matrix to Seeds through an Indicator
 * @author donatmueller
 *
 */
public interface FeatureBinding {
	MatrixFeature getMatrixFeature(); 
	Indicator getIndicator();
}
