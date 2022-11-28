package com.myy803.coursesmanagement.service.statistics;

import org.apache.commons.math3.stat.descriptive.rank.Median;

public class MedianStatisticStrategy extends TemplateStatisticStrategy{


	@Override
	public void doActualCalculation() {

		Median median = new Median();
		
		median.evaluate(getFinalGrades());
		
		super.setStatisticNum(median.evaluate(getFinalGrades()));
	}

}
