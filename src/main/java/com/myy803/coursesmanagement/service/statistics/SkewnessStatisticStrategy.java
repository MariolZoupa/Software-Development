package com.myy803.coursesmanagement.service.statistics;

import org.apache.commons.math3.stat.descriptive.moment.Skewness;

public class SkewnessStatisticStrategy extends TemplateStatisticStrategy {

	public SkewnessStatisticStrategy() {
		
	}
	
	@Override
	public void doActualCalculation() {
		Skewness skewness = new Skewness();
		
		skewness.incrementAll(getFinalGrades());
		
		super.setStatisticNum(skewness.getResult());
	}

}
