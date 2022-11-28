package com.myy803.coursesmanagement.service.statistics;

import org.apache.commons.math3.stat.descriptive.rank.Max;

public class MaxStatisticStrategy extends TemplateStatisticStrategy{

	@Override
	public void doActualCalculation() {
		Max max = new Max();
		
		max.incrementAll(getFinalGrades());
		
		super.setStatisticNum(max.getResult());
	}

}
