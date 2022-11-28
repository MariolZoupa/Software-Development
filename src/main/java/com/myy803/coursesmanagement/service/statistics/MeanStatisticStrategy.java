package com.myy803.coursesmanagement.service.statistics;

import org.apache.commons.math3.stat.descriptive.moment.Mean;

public class MeanStatisticStrategy extends TemplateStatisticStrategy {
	
	public MeanStatisticStrategy() {
		
	}

	@Override
	public void doActualCalculation() {
		Mean mean = new Mean();
		
		mean.incrementAll(getFinalGrades());
		
		super.setStatisticNum(mean.getResult());
	}
	
}
