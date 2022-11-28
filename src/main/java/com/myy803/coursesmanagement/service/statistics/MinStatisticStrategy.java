package com.myy803.coursesmanagement.service.statistics;

import org.apache.commons.math3.stat.descriptive.rank.Min;

public class MinStatisticStrategy extends TemplateStatisticStrategy {

	@Override
	public void doActualCalculation() {
		Min min = new Min();
		
		min.incrementAll(getFinalGrades());
		
		super.setStatisticNum(min.getResult());
	}

}
