package ch.mrs.matrix.math;

import java.util.concurrent.ThreadLocalRandom;

class RandomImpl implements Random {
	

	@Override
	public double random() {
		return ThreadLocalRandom.current().nextDouble();
	}

	@Override
	public int random(int min, int max) {
		return ThreadLocalRandom.current().nextInt(min, max + 1);
	}

	@Override
	public double random(double min, double max) {
		return ThreadLocalRandom.current().nextDouble(min, max + 1);
	}

}
