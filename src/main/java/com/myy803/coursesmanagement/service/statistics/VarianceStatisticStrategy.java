package com.myy803.coursesmanagement.service.statistics;

import org.apache.commons.math3.stat.descriptive.moment.Variance;

public class VarianceStatisticStrategy extends TemplateStatisticStrategy {

	@Override
	public void doActualCalculation() {
		Variance variance = new Variance();
		
		variance.incrementAll(getFinalGrades());
		
		super.setStatisticNum(variance.getResult());
	}

}
