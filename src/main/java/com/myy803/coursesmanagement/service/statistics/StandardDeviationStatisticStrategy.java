package com.myy803.coursesmanagement.service.statistics;

import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;

public class StandardDeviationStatisticStrategy extends TemplateStatisticStrategy {

	@Override
	public void doActualCalculation() {
		StandardDeviation deviation = new StandardDeviation();
		
		deviation.incrementAll(getFinalGrades());
		
		super.setStatisticNum(deviation.getResult());
		
	}

}
