package ch.mrs.matrix;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import ch.mrs.matrix.feature.FeatureBinding;
import ch.mrs.matrix.feature.Indicator;
import ch.mrs.matrix.feature.IndicatorProportion;
import ch.mrs.matrix.feature.ProportionalIndicator;
import ch.mrs.matrix.seed.Seed;

/**
 * The seedshaker instantiates the matrix based on seeds.
 * There are two kind of indicator values that can be mapped to features.
 * Single values without a distribution representing the number of instances of something.
 * For example the count of the population in a region for a year.
 * On the other side there are distributed values representing an attribute of many instances.
 * For example sex has two values 'm' and 'f' with a distribution of 49.2 and 50.8 percent.
 * The seedshaker will create the number of individuals according to the population feature
 * and set the sex among all individuals so that the distribution of 49.2 and 50.8 percent is met.
 * 
 * @see https://oroboro.com/non-uniform-random-numbers/ for a sophisticated distribution algorithm.
 *  
 * @author donatmueller
 *
 * aka MatrixFactory
 */
public class SeedShaker {
	private final static SeedShaker INSTANCE = new SeedShaker();
	private SeedShaker() {
		// factory
	}

	public static SeedShaker getInstance() {
		return SeedShaker.INSTANCE;
	}
	
	public void load(List<Seed> seeds, List<FeatureBinding> bindings) {
		List<String> regionIds = seeds.stream().map(Seed::getRegionId).distinct().collect(Collectors.toList());
		for (String regionId : regionIds) {
			List<Seed> currentRegion = seeds.stream().filter(x -> regionId.equals(x.getRegionId())).collect(Collectors.toList());
			System.out.println(String.format("Processing region: %s", currentRegion.get(0).getRegionName()));
			for (FeatureBinding binding : bindings) {
				Indicator indicator = binding.getIndicator();
				System.out.println(String.format("Matrix Feature: %s - IndicatorId: %s", binding.getMatrixFeature().name(), indicator.getIndicatorId()));
				if (indicator.getIndicatorId().equals(Indicator.PROPORTIONAL_INDICATOR_ID)) {
					ProportionalIndicator proportionalIndicator = (ProportionalIndicator) indicator;
					List<String> indicatorIdSet = proportionalIndicator.getProportions().stream().map(IndicatorProportion::getIndicatorId).collect(Collectors.toList());
					List<Double> indicatorValues = new ArrayList<>();
					for (String indicatorId : indicatorIdSet) {
						// just take the first here, but we could choose the most recent year
						Optional<Seed> seed = currentRegion.stream().filter(x -> indicatorId.equals(x.getIndicatorId())).findFirst(); 
						if (seed.isPresent()) {							
							indicatorValues.add(Double.valueOf(seed.get().getIndicatorValue()));
						}
					}
					proportionalIndicator.loadValue(indicatorValues.toArray(new Double[0]));
					List<Integer> result = new ArrayList<>();
					for (int i=0; i<100; i++) {
						result.add(proportionalIndicator.getValue());
					}
					System.out.println(String.format("Value: %s", result));
				} else {
					// just take the first here, but we could choose the most recent year
					Optional<Seed> seed = currentRegion.stream().filter(x -> indicator.getIndicatorId().equals(x.getIndicatorId())).findFirst(); 
					if (seed.isPresent()) {
						indicator.loadValue(Integer.valueOf(seed.get().getIndicatorValue()));
						int result = indicator.getValue();
						System.out.println(String.format("Value: %s", result));
					}
				}
			}
		}
	}

}
